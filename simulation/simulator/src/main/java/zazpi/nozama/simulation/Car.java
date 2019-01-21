package zazpi.nozama.simulation;

/**
 * The car is the one that will move through the paths to the workstations or the parkings
 **/
public class Car {
	/** 
	 * @param currentPos This indicates the current position of the car
	 * @param id It identifies the car. This way we know which car it is
	 * @param busy With this variable we can see if the car is available to use it or not
	 * @param park With this variable we will know if the car will leave the workstation by
	 * itself or it needs a task to park instead
	 **/
	int id;
	boolean busy;
	boolean park;
	Position currentPos;
	
	public Car(int id,Position currentPos) {
		this.currentPos = currentPos;
		this.id = id;
		busy = false;
		park = true;
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
	 * When a task is created, a car is selected to do it, but it only is able to do one
	 * task at a time, so if a car it isn't available it waits until the car is available
	 * again
	 */
	public synchronized void takeCar () {
		while (busy) {
			try {
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
		busy = true;
		park = false;
	}
	
	/**
	 * After ending the task, the car is able to do another task
	 */
	public synchronized void freeCar () {
		busy = false;
		notifyAll();
	}
	
	/**
	 * See if the car needs to park or not
	 * @return park
	 */
	public synchronized boolean isPark() {
		return park;
	}
	
	/**
	 * Set the car the right to park or not
	 * @param park
	 */
	public synchronized void setPark (boolean park) {
		this.park = park;
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
