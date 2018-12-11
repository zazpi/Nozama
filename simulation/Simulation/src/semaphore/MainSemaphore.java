package semaphore;

public class MainSemaphore {
	public static final int N_REINDEERS = 5;
	ReindeersWaiting reindeersWaiting; //model
	ThreadReindeer [] threadReindeer; //thread parameters
	Thread [] threads; //threads
	
	public MainSemaphore () {
		reindeersWaiting = new ReindeersWaiting(N_REINDEERS);
		threadReindeer = new ThreadReindeer[N_REINDEERS];
		threads = new Thread[N_REINDEERS];
	}
	
	public void createThreads () {
		for (int i=0;i<N_REINDEERS;i++) {
			threadReindeer[i] = new ThreadReindeer(((i+1)*1000), i, reindeersWaiting);
			threads[i] = new Thread(threadReindeer[i], String.valueOf(i));
		}
	}
	
	public void startThreads () {
		for (int i=0;i<N_REINDEERS;i++) {
			threads[i].start();
		}
	}
	
	public void killThreads () {
		for (int i=0;i<N_REINDEERS;i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main (String [] args) {
		MainSemaphore semaphore = new MainSemaphore();
		
		semaphore.createThreads();
		semaphore.startThreads();
		semaphore.killThreads();
		
		System.out.println("Everything was better than expected");
	}
}
