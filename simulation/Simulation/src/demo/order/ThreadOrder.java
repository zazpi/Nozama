package demo.order;

import java.util.List;

import demo.LastOrder;

public class ThreadOrder implements Runnable, LastOrder {
	List<Order> orders;
	
	public ThreadOrder(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public void run() {
		for (Order order : orders) {
			order.setWorkstation();
			System.out.println("Order " + order.id + ": " + order.origin.getId() + " → "
					+ order.destination.getId());
			order.orderArrival();
			try { Thread.sleep(10000); } catch (InterruptedException e) {e.printStackTrace(); }
			System.out.println();
			System.out.println();
			//sleepa
			//kontuz ibili eskaerekin, produktuen workstation-a alda daiteke
		}
		System.out.println("Programa ez da bukatzen, eskuz itxi");
	}

}
