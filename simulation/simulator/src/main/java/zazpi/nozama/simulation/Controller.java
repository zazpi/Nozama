package zazpi.nozama.simulation;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

/**
 * This is the class in which all the movements are done and positions are changed and
 * chosen
 */
public class Controller {
	/**
	 * @param threads: Reference to class Threads to create or/and remove different threads
	 * @param objects: Reference to class Objects to use different objects and methods
	 * @param monitor: This monitor is used because a car only can do a task at a time
	 * @param condNotBusy: It references to the monitor
	 **/
	private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	Threads threads;
	Objects objects;
	Lock monitor;
	Condition condNotBusy;
	
	public Controller (Objects objects) {
		this.objects = objects;
		monitor = new ReentrantLock();
		condNotBusy = monitor.newCondition();
	}
	
	/**
	 * This method takes the reference of the threads class
	 * @param threads
	 **/
	public void setThreads (Threads threads) {
		this.threads = threads;
	}
	
	/**
	 * When a task is created, a car is selected to do it, but it only is able to do one
	 * task at a time, so if a car it isn't available it waits until the car is available
	 * again
	 * @param car
	 **/
	public void takeCar (Car car) {
		monitor.lock();		
		while (car.isBusy()) {
			try {
				condNotBusy.await();
			} catch (InterruptedException e) {
				LOGGER.severe("Exception: " + e.getMessage());
				Thread.currentThread().interrupt();
			}
		}
		car.setBusy(true);
		car.setPark(false);
		monitor.unlock();
	}
	
	/**
	 * After ending the task, the car is able to do another task
	 * @param car
	 **/
	public void freeCar (Car car) {
		monitor.lock();
		car.setBusy(false);
		condNotBusy.signalAll();
		monitor.unlock();
	}
	
	/**
	 * There are two different tasks, this one is to take a product to bring it to a
	 * workstation. So first the car goes to the first workstation to take the product and
	 * then it goes to the final workstation
	 * @param origin workstation
	 * @param destination workstation
	 * @param car
	 */
	public void goToWorkstation (WorkStation origin, WorkStation destination, Car car) {
		takeCar(car);		
		Position finalPos = origin.getPath();
		goTo(finalPos, car, origin);
		car.setPark(true);
		Util.safeSleep(5000);
		finalPos = destination.getPath();
		goTo(finalPos, car, destination);
		freeCar(car);
	}
	
	/**
	 * If a car goes to an occupied workstation, the car of the workstation will exit
	 * and go to a parking
	 * @param parking
	 * @param car
	 */
	public void park (Parking parking, Car car) {
		takeCar(car);
		Position finalPos = parking.getPath();
		goTo(finalPos, car, parking);
		freeCar(car);
	}
	
	/**
	 * This method is the circuit the car will follow to arrive to its destination
	 * @param final path
	 * @param car
	 * @param position: workstation or parking
	 */
	public void goTo(Position finalPos, Car car, Position position) {
		Position currentPos;
		Position nextPos = null;
		
		ensureItsInPath(car);
		
		while(car.getCurrentPos() != finalPos){
			currentPos = car.getCurrentPos();
			if(nextPos == null) {
				nextPos = askNextPos(currentPos,finalPos);
				LOGGER.info("Car " + car.getId() +
						" Current: " + currentPos.getRow() + currentPos.getNum() +
						" Next: " + nextPos.getRow() + nextPos.getNum());
				currentPos.moveInsideThePath(100);
				if ((nextPos == finalPos) && (position instanceof WorkStation))
						((WorkStation) position).take(Controller.this, car);
			}else {
				nextPos.take();
				changePosition(nextPos, car);
				nextPos = null;
				currentPos.setPos(0);
			}
		}
		car.getCurrentPos().moveInsideThePath(50);
		LOGGER.info("Car " + car.getId() +
				" Current: " + car.getCurrentPos().getRow() + car.getCurrentPos().getNum());
		changePosition(position, car);
		setPos(position);
		
		LOGGER.info("Car " + car.getId() + " in " +
				car.getCurrentPos().getRow() + car.getCurrentPos().getNum());
	}
	
	/**
	 * The car can have different positions and this method is used to change the position
	 * and to free it
	 * @param new position
	 * @param car
	 */
	public void changePosition (Position newPos, Car car) {
		car.getCurrentPos().free();
		car.setCurrentPos(newPos);
	}
	
	/**
	 * If a car is in a workstation or in a parking, it will change its position to the
	 * path it corresponds
	 * @param car
	 **/
	public void ensureItsInPath (Car car) {
		if (car.getCurrentPos() instanceof WorkStation) {
			((WorkStation) car.getCurrentPos()).leave();
			car.getCurrentPos().setPos(50);
		}else if (car.getCurrentPos() instanceof Parking) {
			((Parking) car.getCurrentPos()).leave();
			car.getCurrentPos().setPos(50);
		}
	}
	/**
	 * 
	 * @param position
	 */
	public void setPos (Position position) {
		if (position instanceof WorkStation) ((WorkStation) position).getPath().setPos(0);
		else if (position instanceof Parking) ((Parking) position).getPath().setPos(0);
	}
	
	/**
	 * It will return the next position the car have to follow in order to arrive to its
	 * destination
	 * @param current position
	 * @param final position
	 * @return next position
	 */
	public Position askNextPos(Position currentPos, Position finalPos) {
		Position nextPos;
		int nA = currentPos.getNum();
		int nB = finalPos.getNum();
		String rA = currentPos.getRow();
		String rB = finalPos.getRow();
		
		if(rA.equals(rB)) nextPos = sameRow(rA, nA, nB);
		else nextPos = differentRow (rA, nA, nB);
		
		return nextPos;		
	}
	
	/**
	 * After calling askNextPost method, it will do this if the rows of the current position
	 * and the final position are the same
	 * @param row
	 * @param current position's column
	 * @param final position's column
	 * @return next position
	 */
	public Position sameRow(String row, int currentNum, int finalNum) {		
		int  num = currentNum;
		
		if (row.equals("A")) {			
			if ((currentNum < finalNum) && (currentNum % 2 == 0)) row = "AB";
			else num--;
		}else {
			num++;
			if ((currentNum > finalNum) && (currentNum % 2 == 0)) row = "AB";
		}
		
		return objects.getPosition(row, num);
	}
	
	/**
	 * After calling askNextPost method, it will do this if the rows of the current position
	 * and the final position are different
	 * @param row
	 * @param current position's column
	 * @param final position's column
	 * @return next position
	 */
	public Position differentRow (String row, int currentNum, int finalNum) {
		int num = currentNum;
		
		if (row.equals("AB")) {
			if (currentNum % 2 == 0) row = "B";
			else {
				row = "A";
				num--;
			}
		}else if (row.equals("A")) {
			if ((currentNum <= finalNum) && (currentNum % 2 == 0)) row = "AB";
			else num--;
		}else {
			num++;
			if ((currentNum >= finalNum) && (currentNum % 2 == 0)) row = "AB";
		}
		
		return objects.getPosition(row, num);
	}
	
	/**
	 * If a car has to move to a parking, this method will return the nearest parking
	 * that is free
	 * @param car
	 * @param workstation's row
	 * @param workstation's column
	 * @return parking
	 */
	public synchronized Parking chooseBestParking (Car car, String row, int num) {
		int parkingNum = num;
		Parking parking;
		
		if (row.equals("AW")) {
			parking = carInRowA(num, parkingNum);
		}else {
			parking = carInRowB(num, parkingNum);
		}
		parking.setCar(car);
			
		return parking;
	}
	
	/**
	 * After calling chooseBestParking method, it will do this if the workstation is in the
	 * first row
	 * @param workstation's column
	 * @param parking's column
	 * @return parking
	 */
	public Parking carInRowA (int num, int parkingNum) {
		String parkingRow = "";
		boolean available;
		boolean bool = (num == 0);
		
		if (num == 0) {
			parkingRow = "BP";
			parkingNum = 0;
		}else {
			parkingRow = "AP";
			parkingNum--;
		}
			
		do {
			available = seeParkingAvailability(parkingRow, parkingNum);
			if (!available) {
				if (num > 0) {
					if (num == 2) parkingNum--;
					else {
						parkingRow = "BP";
						parkingNum = 1;
					}
					num--;
				}else {
					if (parkingNum == 1) {
						if (bool) parkingRow = "AP";
						parkingNum = 0;
					}else {
						if (!bool) parkingRow = "AP";
						parkingNum++;
					}
				}
			}
		}while (!available);		
		
		return objects.getParking(parkingRow, parkingNum);
	}
	
	/**
	 * After calling chooseBestParking method, it will do this if the workstation is in the
	 * second row
	 * @param workstation's column
	 * @param parking's column
	 * @return parking
	 */
	public Parking carInRowB (int num, int parkingNum) {
		String parkingRow = "";
		boolean available;
		boolean bool = (num == 2);
		
		if (num == 2) {
			parkingRow = "AP";
			parkingNum = 1;
		}else parkingRow = "BP";
		
		do {
			available = seeParkingAvailability(parkingRow, parkingNum);
			if (!available) {
				if (num < 2) {
					if (num == 0) parkingNum++;
					else {
						parkingRow = "AP";
						parkingNum = 0;
					}
					num++;
				} else {
					if (parkingNum == 0) {
						if (bool) parkingRow = "BP";
						parkingNum++;
					}else {
						if (!bool) parkingRow = "BP";
						parkingNum = 0;
					}
				}
			}
			
		}while (!available);
		
		return objects.getParking(parkingRow, parkingNum);
	}
	
	/**
	 * It sees if a parking is available or not
	 * @param parking's row
	 * @param parking' column
	 * @return availability
	 */
	public boolean seeParkingAvailability (String row, int num) {
		Parking parking = objects.getParking(row, num);
		
		return parking.available();		
	}
	
	/**
	 * This method will create a thread to move a car from a workstation to a parking 
	 * @param car
	 * @param workstation
	 */
	public void createTaskToPark(Car car, WorkStation workstation) {
		threads.createTaskToPark(car, workstation);		
	}	
}
