package zazpi.nozama.simulation;

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
	int id;
	Controller controller;
	Car car;
	WorkStation aPos, bPos;
	
	public Task(int id,Car car,Controller controller, WorkStation aPos, WorkStation bPos) {
		this.id = id;
		this.car = car;
		this.controller = controller;
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
		System.out.println("Task " + id + " started");	
		controller.goToWorkstation(aPos, bPos, car);
		System.out.println("Task " + id + " FINISHED");
	}	
}
