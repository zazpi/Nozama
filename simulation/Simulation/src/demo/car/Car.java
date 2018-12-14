package demo.car;

import demo.order.Product;
import demo.position.Position;

public class Car {
	int id;
	Position position;
	boolean moveToParking;
	Product product;
	
	public Car (int id, Position position) {
		this.id = id;
		this.position = position;
		moveToParking = false;
	}	

	public int getId() {
		return id;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
		this.position.changeState();
	}

	public boolean isMoveToParking() {
		return moveToParking;
	}

	public void setMoveToParking() {
		moveToParking = !moveToParking;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
