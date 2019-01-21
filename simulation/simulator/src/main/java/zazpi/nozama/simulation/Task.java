package zazpi.nozama.simulation;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.Buffer;
import java.util.logging.Logger;

import zazpi.nozama.webserver.Core;

/**
 * This thread is to move a car from a workstation to another in order to carry one product
 * to its destination
 **/
public class Task implements Runnable {
	/**
	 * @param id: thread number. it identifies the thread
	 * @param controller: it does all the movements
	 * @param car: the thread need the information of which car have to be moved
	 * @param aPos: the origin workstation
	 * @param bPos: the destination workstation
	 */
	private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	int id;
	Controller controller;
	int suborderId;
	int productId;
	Car car;
	WorkStation aPos;
	WorkStation bPos;
	
	public Task(int id, Controller controller, int suborderId, int productId, WorkStation aPos, WorkStation bPos) {
		this.id = id;
		this.controller = controller;
		this.suborderId = suborderId;
		this.productId = productId;
		this.aPos = aPos;
		this.bPos = bPos;
	}	
	
	/**
	 * Get the id to identify the thread
	 * @return id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * This is what the thread will do
	 **/
	public void run() {
		LOGGER.info("Task " + id + " started");
		car = controller.takeCar();
		controller.goToWorkstation(aPos, bPos, car);
		notifyFinish();
		LOGGER.info("Task " + id + " FINISHED");
	}
	
	public void notifyFinish () {
		URL url;
		try {
			url = new URL(Core.APP_URL_DOCKER + "/api/order/updateSuborder?productId=" + productId +
					"&subOrderId=" + suborderId);
			System.out.println(url);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.getResponseCode();
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine = in.readLine();
			boolean bool = Boolean.parseBoolean(inputLine);
			in.close();
			if (bool) {
				LOGGER.info("FREE");
				bPos.setOrder(false);
			}
		} catch (IOException e) {
			LOGGER.severe("Exception: " + e.getMessage());
			Thread.currentThread().interrupt();
		}
	}
}
