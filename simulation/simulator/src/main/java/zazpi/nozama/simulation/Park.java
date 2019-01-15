package zazpi.nozama.simulation;

public class Park implements Runnable {
	int id;
	Controller controller;
	Car car;
	Position nextPos;
	Parking parking;	
	
	public Park (int id, Car car,Controller controller, Parking parking) {
		this.id = id;
		this.car = car;
		this.controller = controller;
		this.parking = parking;
	}
	
	public int getId() {
		return id;
	}
	
	public void run () {
		System.out.println("Task to park " + id + " started");
		controller.park(parking, car);
		System.out.println("Task to park " + id + " FINISHED");
	}
}
