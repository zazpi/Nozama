package monitor;

public class ThreadProducer implements Runnable, Variables {
	int threadNumber;
	Fifo fifo;
	
	public ThreadProducer (int threadNumber, Fifo fifo) {
		this.threadNumber = threadNumber;
		this.fifo = fifo;
	}

	@Override
	public void run() {
		float f = 0;
		
		for (int i=0; i < MAX_PRODUCTS;i++) {
			try {
				Thread.sleep(500);
				fifo.put(f); 
			} catch (InterruptedException e) {e.printStackTrace(); }
			f+=15;
		}
	}
}
