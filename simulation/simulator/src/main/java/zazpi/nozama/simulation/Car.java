package zazpi.nozama.simulation;

public class Car {
	int id;
	boolean busy;
	Position currentPos;
	
	public Car(int id,Position currentPos) {
		this.currentPos = currentPos;
		this.id = id;
		this.busy = false;
	}

	public int getId() {
		return id;
	}

	public synchronized boolean isBusy() {
		return busy;
	}

	public synchronized void setBusy(boolean busy) {
		this.busy = busy;
	}

	public synchronized Position getCurrentPos() {
		return currentPos;
	}

	public synchronized void setCurrentPos(Position currentPos) {
		this.currentPos = currentPos;
	}

}
