package demo.position;

import java.util.ArrayList;
import java.util.List;

import demo.order.Product;

public class Workstation extends Position {
	List<Product> listProduct;
	
	public Workstation (int id) {
		super(id);
		listProduct = new ArrayList<>();
	}
	
	public void setOrder (List<Product> order) {
		listProduct = order;
		if (listProduct.size() >= 0 && state != State.READY) state = State.PREPARING;
	}
	
	public synchronized void takeProduct (int id) throws InterruptedException {
		System.out.println("Worker " + id + " preparing the order");
		Thread.sleep(5000);
		System.out.println("Order ready to deliver");
		state = State.READY;
	}
	
	public synchronized void leaveProduct () throws InterruptedException {
		System.out.println("Worker " + id + " taking the product");
		Thread.sleep(1000);
		System.out.println("Can continue with other products");
	}
	
	public List<Product> getListProduct () {
		return listProduct;
	}
}
