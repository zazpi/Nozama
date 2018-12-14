package demo.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import demo.LastOrder;
import demo.order.Product;
import demo.position.Parking;
import demo.position.Workstation;

public class ThreadCar implements Runnable, LastOrder {
	int id;	
	Car car;
	Cars cars;
	List<Workstation> workstations;
	List<Parking> parkings;
	boolean move;
	
	public ThreadCar(int id, List<Workstation> workstations, List<Parking> parkings,
			Car car, Cars cars) {
		this.id = id;
		this.workstations = new ArrayList<>(workstations);
		Collections.copy(this.workstations, workstations);
		this.parkings = new ArrayList<>(parkings);
		Collections.copy(this.parkings, parkings);
		this.car = car;
		this.cars = cars;
		move = false;
	}
	
	@Override
	public void run() {
		//ikusi workstation-an egoera - while
		//kotxiari workstation-a jarri
		while (!LAST_ORDER) {
		
		
		try { Thread.sleep(100); } catch (InterruptedException e) {e.printStackTrace(); }
		for (int i=0;i<workstations.size();i++) {
			if (!move) move = cars.setWorkstation(id, workstations.get(i));
		}
		
		if (move) {
			
			try { cars.moveToAnotherWorkstation(id); } catch (InterruptedException e) {e.printStackTrace(); }
			
			for (Product product : ((Workstation) car.getPosition()).getListProduct()) {
				
				try {
					cars.moveWithTheProduct(id, product, product.getDestination());
					cars.moveToAnotherWorkstation(id);
					// azkenak ez luke egin behar
					cars.moveToTakeAnotherProduct(id, product.getOrigin());
					cars.moveToAnotherWorkstation(id);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			move = false;
			break;
		}
		
		boolean moveToParking = car.isMoveToParking();
		if (moveToParking) {
			cars.park(id, parkings);
			car.setMoveToParking();
		}
	
		
		}
	}
}
