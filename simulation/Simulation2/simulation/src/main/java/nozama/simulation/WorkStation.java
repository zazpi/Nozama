package nozama.simulation;

public class WorkStation extends Position {
	Position path;
	
	public WorkStation(String row, int num, boolean available, Position path) {
		super(row, num, available);
		this.path = path;
	}

	public Position getPath() {
		return path;
	}
	
	public void leave (Car car) {
		path.take();
		car.setCurrentPos(path);
	}
}
