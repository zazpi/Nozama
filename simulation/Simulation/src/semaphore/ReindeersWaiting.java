package semaphore;

import java.util.concurrent.Semaphore;

public class ReindeersWaiting {
	Semaphore sEntry, sMutEx, sExit, sSanta;
	int nReindeersWaiting;
	int N;
	
	public ReindeersWaiting (int n) {
		nReindeersWaiting = 0;
		N = n;
		sEntry = new Semaphore(n);
		sMutEx = new Semaphore(1);
		sExit = new Semaphore(0);
		sSanta = new Semaphore(0);
	}
	
	public void waitInWarmHut (int threadNumber) throws InterruptedException {
		boolean azkena;
		
		sEntry.acquire();
		
		sMutEx.acquire();		
		System.out.println("Reindeer " + threadNumber + " arriving from vacation");
		nReindeersWaiting++;
		azkena = (nReindeersWaiting == N)? true:false;		
		if (azkena) {
			System.out.println("Reindeer " + threadNumber + " awakening Santa\n");
			sSanta.release();
			for (int i=0; i < N;i++) sExit.release();
		}
		sMutEx.release();
		
		if (!azkena) System.out.println("Reindeer " + threadNumber + " waiting in the warm hut");		
		sExit.acquire();
		Thread.sleep(500);
		
		sMutEx.acquire();			
		System.out.println("Reindeer " + threadNumber + " starting the trip");
		nReindeersWaiting--;
		if (nReindeersWaiting == 0) {
			for (int i=0; i < N;i++) sEntry.release();
		}
		sMutEx.release();
	}
}
