package zazpi.nozama.simulation;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This thread is to move a car from a workstation to a parking in order to empty that
 * workstation
 **/
public class Park implements Runnable {
	/**
	 * @param id: thread number. it identifies the thread
	 * @param controller: it does all the movements
	 * @param car: the thread need the information of which car have to be moved
	 * @param parking: the destination of the car
	 **/
	private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	int id;
	Controller controller;
	Car car;
	Parking parking;	
	
	public Park (int id, Car car,Controller controller, Parking parking) {
		this.id = id;
		this.car = car;
		this.controller = controller;
		this.parking = parking;
	}
	
	/**
	 * Get the id to identify the thread
	 * @return id
	 **/
	public int getId() {
		return id;
	}
	
	/**
	 * This is what the thread will do
	 **/
	public void run () {
		LOGGER.info("Task to park " + id + " started");
		controller.park(parking, car);
		LOGGER.info("Task to park " + id + " FINISHED");
	}
}
