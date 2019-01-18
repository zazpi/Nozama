package zazpi.nozama.simulation;

import java.util.logging.Logger;

/**
 * Parking is one of the different position types
 * It uses Position class' methods apart from a couple of new ones
 **/
public class Parking extends Position {
	/**
	 * @param path: this is the path that is connected to the parking
	 * @param car: if the parking is occupied, it will have the information of which car it is
	 **/
	private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	Position path;
	Car car;
	
	public Parking(String row, int num, boolean available, Position path) {
		super(row, num, available);
		this.path = path;
	}
	
	/**
	 * Get the position to which is connected
	 * @return position
	 **/
	public Position getPath() {
		return path;
	}
	
	/**
	 * It sets the car in the current parking and it puts as unavailable
	 * @param car
	 **/
	public void setCar(Car car) {
		this.car = car;
		available = false;
	}
	
	/**
	 * The car leaves the parking, putting it available and without the car. The method
	 * also sets the car's position to the one that is connected to the parking and
	 * changes the positions availability to occupied
	 **/
	public void leave () {
		LOGGER.info("Car " + car.getId() + " living parking " + row+num);
		path.take();
		car.setCurrentPos(path);
		car = null;
		available = true;
	}
}
