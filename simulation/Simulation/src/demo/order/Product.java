package demo.order;

import demo.position.Workstation;

public class Product {
	int id;
	Workstation origin, destination;
	
	public Product (int id) {
		this.id = id;
	}
	
	public void setWorkstations (Workstation origin, Workstation destination) {
		this.origin = origin;
		this.destination = destination;
	}	

	public int getId() {
		return id;
	}
	
	public Workstation getOrigin () {
		return origin;
	}
	
	public Workstation getDestination () {
		return destination;
	}

	@Override
	public String toString() {
		return id + ": " + origin.getId() + " → " + destination.getId();
	}
}
