package monitorSynchronized;

public class MainSynchronized {
	public static final int N_CARS = 10;
	
	Parking parking; //model
	ThreadCar [] threadCar; //thread parameters
	Thread [] threads; //threads
	
	public MainSynchronized () {
		parking = new Parking(N_CARS);
		threadCar = new ThreadCar[N_CARS];
		threads = new Thread[N_CARS];
	}
	
	public void createThreads () {
		int i=0;
		
		for (i=0;i<N_CARS;i++) {
			threadCar[i] = new ThreadCar(i, parking);
			threads[i] = new Thread(threadCar[i], String.valueOf(i));
		}
	}
	
	public void startThreads () {
		for (int i=0;i<N_CARS;i++) {
			threads[i].start();
		}
	}
	
	public void killThreads () {
		for (int i=0;i<N_CARS;i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main (String [] args) {
		MainSynchronized monitor = new MainSynchronized();
		
		monitor.createThreads();
		monitor.startThreads();
		monitor.killThreads();
		
		System.out.println("\nEverything was better than expected");
	}
}
