package monitorSynchronized;

public class Parking {
	enum State {
		CLOSED, OPEN;
	}
	State state;
	int nCarsInParking;
	int N;
	
	public Parking (int n) {
		nCarsInParking = 0;
		N = n;
		state = State.OPEN;
	}
	
	public synchronized void enterParking (int licenseNumber) throws InterruptedException {
		while (state == State.CLOSED) wait();
		nCarsInParking++;
		System.out.println("\tCar " + licenseNumber + " parked");
		if (nCarsInParking == (N-3)) {
			System.out.println("CLOSED");
			state = State.CLOSED;
		}
	}
	
	public synchronized void exitParking (int licenseNumber) {
		nCarsInParking--;
		System.out.println("\t\tCar " + licenseNumber + " going out of the parking");
		if (state == State.CLOSED && nCarsInParking == (N-5)) {
			System.out.println("OPENED");
			state = State.OPEN;
			notifyAll();
		}
	}
	
}
