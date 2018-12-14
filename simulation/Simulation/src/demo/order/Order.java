package demo.order;

import java.util.List;

import demo.position.Workstation;

public class Order {
	int id;
	List<Product> order;
	Workstation origin, destination;
	
	public Order (int id, List<Product> order, Workstation origin, Workstation destination) {
		this.id = id;
		this.order = order;
		this.origin = origin;
		this.destination = destination;
	}
	
	public void orderArrival () {
		origin.setOrder(order);
	}
	
	public void setWorkstation () {
		for (Product product : order) {
			product.setWorkstations(origin, destination);
		}
	}

	@Override
	public String toString() {
		return "Order " + id + ": " + origin.getId() + " " + destination.getId();
	}
	
	
}
