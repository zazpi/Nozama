package zazpi.nozama.simulation;

import java.util.logging.Logger;

/**
 * Workstation is one of the different position types
 * It uses Position class' methods apart from a couple of new ones
 **/
public class WorkStation extends Position {
	/**
	 * @param path: this is the path that is connected to the parking
	 * @param car: if the parking is occupied, it will have the information of which car it is
	 * @param order: it indicates if the workstation has an order or not
	 **/
	private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	Position path;
	Car car;
	boolean order;
	
	public WorkStation(String row, int num, boolean available, Position path) {
		super(row, num, available);
		this.path = path;
		order = false;
	}
	
	/**
	 * Get the position to which is connected
	 * @return position
	 **/
	public Position getPath() {
		return path;
	}
	
	/**
	 * It sets the car in the current workstation
	 * @param car
	 **/
	public void setCar(Car car) {
		this.car = car;
	}
	
	/**
	 * It returns if the workstation can be used to set an order or not
	 * @return order
	 */
	public synchronized boolean isOrder() {
		return order;
	}
	
	/**
	 * It sets true when an order arrives and false when it ends
	 * @param order
	 */
	public synchronized void setOrder(boolean order) {
		this.order = order;
	}

	/**
	 * The car leaves the parking, putting it available and without the car. The method
	 * also sets the car's position to the one that is connected to the parking and
	 * changes the positions availability to occupied
	 **/
	public synchronized void leave () {
		LOGGER.info("Car " + car.getId() + " living workstation " + row+num);
		path.take();
		car.setCurrentPos(path);
		car = null;
		available = true;
		notifyAll();
	}
	
	/**
	 * Only one car can stay in a workstation and if it is occupied, it will wait to be
	 * emptied. If the car in the workstation isn't doing anything, a thread will be
	 * created to free the workstation and the car will go to a parking
	 * @param controller
	 * @param car
	 */
	public synchronized void take(Controller controller, Car car) {
		if (!available && this.car.isPark()) {
				this.car.setPark(false);
				controller.createTaskToPark(this.car, this);
		}
		
		try {
			while(!available) {
				LOGGER.info("Car " + car.getId() + " waiting workstation " +
						row+num + " to be emptied");
				wait();
			}
			setCar(car);
			available = false;
		} catch (InterruptedException e) {
			LOGGER.severe("Exception: " + e.getMessage());
			Thread.currentThread().interrupt();
		}
	}	
}
