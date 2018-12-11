package monitor;

public class MainMonitor implements Variables {	
	Fifo fifo; //model
	ThreadProducer [] threadProducer; //thread parameters
	ThreadConsumer [] threadConsumer; //thread parameters
	Thread [] threads; //threads
	
	public MainMonitor () {
		fifo = new Fifo(MAX_BUFFER_SIZE);
		threadProducer = new ThreadProducer[N_PRODUCERS];
		threadConsumer = new ThreadConsumer[N_CONSUMERS];
		threads = new Thread[(N_PRODUCERS+N_CONSUMERS)];
	}
	
	public void createThreads () {
		int i=0;
		
		for (i=0;i<N_PRODUCERS;i++) {
			threadProducer[i] = new ThreadProducer(i, fifo);
			threads[i] = new Thread(threadProducer[i], String.valueOf(i));
		}
		
		for (int j=i;j<(N_PRODUCERS+N_CONSUMERS);j++) {
			threadConsumer[j-i] = new ThreadConsumer((j-i), fifo);
			threads[j] = new Thread(threadConsumer[j-i], String.valueOf(j-i));
		}
	}
	
	public void startThreads () {
		for (int i=0;i<(N_PRODUCERS+N_CONSUMERS);i++) {
			threads[i].start();
		}
	}
	
	public void killThreads () {
		for (int i=0;i<(N_PRODUCERS+N_CONSUMERS);i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main (String [] args) {
		MainMonitor monitor = new MainMonitor();
		
		monitor.createThreads();
		monitor.startThreads();
		monitor.killThreads();
		
		System.out.println("\nEverything was better than expected");
	}
}
