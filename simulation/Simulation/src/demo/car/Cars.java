package demo.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import demo.order.Product;
import demo.position.Parking;
import demo.position.Position;
import demo.position.Position.State;
import demo.position.Workstation;

public class Cars {
	List<Car> cars;
	int nCars;
	
	public Cars (int n, List<Car> cars) {
		nCars = n;
		this.cars = new ArrayList<>(cars);
		Collections.copy(this.cars, cars);
	}
	
	public synchronized boolean setWorkstation (int carNumber, Workstation workstation) {
		if (workstation.getState() == workstation.getState().READY) {
			System.out.println("Workstation " + workstation.getId());
			if (cars.get(carNumber).getPosition() instanceof Parking) {
				moveToWorkstation(carNumber, cars.get(carNumber).getPosition());
			}
			cars.get(carNumber).setPosition(workstation);
			System.out.println("Kotxe " + carNumber + ", hona jun " + cars.get(carNumber).getPosition().getId());
			return true;
		}
		return false;		
	}
	
	public synchronized void moveToAnotherWorkstation (int carNumber) throws InterruptedException {
		int workstation = cars.get(carNumber).getPosition().getId();
		
		for (int i=0;i<nCars;i++) {
			if (i != carNumber) {
				if (cars.get(i).getPosition() instanceof Workstation) {
					int to = cars.get(i).getPosition().getId();
					if (workstation == to) {
						cars.get(i).setMoveToParking();
						System.out.println("Workstation " + cars.get(i).getPosition().getState()
								+ " (Car " + cars.get(i).getId() + "). Waiting to be free");
						wait();
						System.out.println("Workstation free");
						break;
					}
				} 
			}
		}
	}
	
	public synchronized void moveWithTheProduct (int carNumber, Product product, Workstation workstation) {
		cars.get(carNumber).setPosition(workstation);
		cars.get(carNumber).setProduct(product);
		System.out.println("Produktu " + product.getId() + " eramaten " + workstation.getId() + "-ra");
	}
	
	public synchronized void moveToTakeAnotherProduct (int carNumber, Workstation workstation) {
		cars.get(carNumber).setPosition(workstation);
		System.out.println("Origenera bueltatzen " + workstation.getId());
	}
	
	public synchronized void moveToWorkstation (int carNumber, Position parking) {
		if (cars.get(carNumber).getPosition() instanceof Parking) {
			parking.changeState();
			System.out.println("Leaving parking " + parking.getId());
			//cars.get(carNumber).setMoveToParking();
		}
	}
	
	public synchronized void park (int carNumber, List<Parking> parkings) {
		cars.get(carNumber).getPosition().changeState();
		int workstation = cars.get(carNumber).getPosition().getId();
		
		for (Parking parking : parkings) {
			if (parking.getState() == State.FREE) {
				cars.get(carNumber).setPosition(parking);
				break;
			}
		}
		
		System.out.println("Workstation " + workstation + " " + cars.get(carNumber).getPosition().getState());
		System.out.println("Car " + cars.get(carNumber).getId() + " parked");
		
		notifyAll();
	}
}
