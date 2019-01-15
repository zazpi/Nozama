package nozama.simulation;

public class Task implements Runnable {
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

	public int getId() {
		return id;
	}

	public void run() {
		System.out.println("Task " + id + " started");	
		controller.goToWorkstation(aPos, bPos, car);
		System.out.println("Task " + id + " FINISHED");
	}	
}
