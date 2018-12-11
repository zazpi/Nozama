package monitor;

public class ThreadConsumer implements Runnable, Variables {
	int threadNumber;
	Fifo fifo;
	
	public ThreadConsumer (int threadNumber, Fifo fifo) {
		this.threadNumber = threadNumber;
		this.fifo = fifo;
	}

	@Override
	public void run() {
		float f = -1;
		
		for (int i=0; i < ((MAX_PRODUCTS*N_PRODUCERS)/N_CONSUMERS);i++) {
			try { 
				Thread.sleep(2000);
				f = fifo.get();
			} catch (InterruptedException e) {e.printStackTrace(); }
			System.out.println(threadNumber + " consuming → " + f + "\n");
		}
	}
}
