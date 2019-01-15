package nozama.simulation;

public class WorkStation extends Position {
	Position path;
	Car car;
	
	public WorkStation(String row, int num, boolean available, Position path) {
		super(row, num, available);
		this.path = path;
	}

	public Position getPath() {
		return path;
	}
	
	public void setCar(Car car) {
		this.car = car;
	}

	public synchronized void leave () {
		System.out.println("Car " + car.getId() + " living workstation " + row+num);
		path.take();
		car.setCurrentPos(path);
		car = null;
		available = true;
		notify();
	}

	public synchronized void take(Controller controller, Car car) {
		if (!available) {
			Util.safeSleep(10);
			if (!this.car.isBusy()) controller.createTaskToPark(this.car, this);
		}
		
		try {
			while(!available) {
				System.out.println("Car " + car.getId() + " waiting workstation " +
						row+num + " to be emptied");
				wait();
			}
			setCar(car);
			available = false;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
