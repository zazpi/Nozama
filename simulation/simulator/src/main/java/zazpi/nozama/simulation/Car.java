package zazpi.nozama.simulation;

/**
 * The car is the one that will move through the paths to the workstations or the parkings
 **/
public class Car {
	/** 
	 * @param currentPos This indicates the current position of the car
	 * @param id It identifies the car. This way we know which car it is
	 * @param busy With this variable we can see if the car is available to use it or not
	 **/
	int id;
	boolean busy;
	Position currentPos;
	
	public Car(int id,Position currentPos) {
		this.currentPos = currentPos;
		this.id = id;
		this.busy = false;
	}
	
	/**
	 * Get the id of the car to identify it
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * See if the car is available or not
	 * @return busy
	 */
	public synchronized boolean isBusy() {
		return busy;
	}
	
	/**
	 * Set the car to busy or not busy
	 * @param busy
	 */
	public synchronized void setBusy(boolean busy) {
		this.busy = busy;
	}
	
	/**
	 * Get the current position of the car
	 * @return currentPos
	 **/
	public synchronized Position getCurrentPos() {
		return currentPos;
	}
	
	/**
	 * Change the current position of the car
	 * @param currentPos
	 */
	public synchronized void setCurrentPos(Position currentPos) {
		this.currentPos = currentPos;
	}

}
