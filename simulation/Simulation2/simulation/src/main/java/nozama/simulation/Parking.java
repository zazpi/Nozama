package nozama.simulation;

public class Parking extends Position {
	Position path;
	Car car;	
	
	public Parking(String row, int num, boolean available, Position path) {
		super(row, num, available);
		this.path = path;
	}
	
	public Position getPath() {
		return path;
	}
	
	public void setCar(Car car) {
		this.car = car;
		available = false;
	}

	public void leave () {
		System.out.println("Car " + car.getId() + " living parking " + row+num);
		path.take();
		car.setCurrentPos(path);
		car = null;
		available = true;
	}
}
