package monitorSynchronized;

public class ThreadCar implements Runnable {
	int licenseNumber;
	Parking parking;
	
	public ThreadCar (int licenseNumber, Parking parking) {
		this.licenseNumber = licenseNumber;
		this.parking = parking;
	}

	@Override
	public void run() {
		System.out.println("Car " + licenseNumber + " trying to enter into the parking");
		try {
			parking.enterParking(licenseNumber);
			Thread.sleep(5000);
		} catch (InterruptedException e) {e.printStackTrace(); }
		parking.exitParking(licenseNumber);
	}
	
	
}
