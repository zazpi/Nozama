package demo;

import demo.position.Workstation;

public class ThreadWorker implements Runnable, LastOrder {
	int id;
	Workstation workstation;
	
	public ThreadWorker (int id, Workstation workstation) {
		this.id = id;
		this.workstation = workstation;
	}
	
	@Override
	public void run() {
		while (!LAST_ORDER) {
			
		
		try {
			Thread.sleep(500);
			if (workstation.getState() == workstation.getState().PREPARING) {
				workstation.takeProduct(id);
			}
		} catch (InterruptedException e) {e.printStackTrace(); }
		
		
		}
	}
}
