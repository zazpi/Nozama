package semaphore;

public class ThreadReindeer implements Runnable {
	public int years = 3;
	
	int sleepTime;
	int threadNumber;
	ReindeersWaiting reindeersWaiting; // thread denek balio berdina
	
	public ThreadReindeer (int sleepTime, int threadNumber, ReindeersWaiting reindeersWaiting) {
		this.sleepTime = sleepTime;
		this.threadNumber = threadNumber;
		this.reindeersWaiting = reindeersWaiting;
	}
	
	public void waitYear () {
		for (int i=0; i < 5;i++) {
			try { Thread.sleep(1000); } catch (InterruptedException e) {e.printStackTrace(); }
			if (threadNumber == 0) System.out.print("·");
		}
		if (threadNumber == 0) System.out.println("\n");
	}
	
	@Override
	public void run () {
		for (int i=0;i<years;i++) {
			try {
				Thread.sleep(sleepTime);
				reindeersWaiting.waitInWarmHut(threadNumber);
			} catch (InterruptedException e) {e.printStackTrace(); }			
			waitYear();
		}
	}	
}
