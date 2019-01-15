package nozama.simulation;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Controller {
	Threads threads;
	Objects objects;
	Lock monitor;
	Condition condNotBusy;
	
	public Controller (Objects objects) {
		this.objects = objects;
		monitor = new ReentrantLock();
		condNotBusy = monitor.newCondition();
	}
	
	public void setThreads (Threads threads) {
		this.threads = threads;
	}
	
	public void takeCar (Car car) {
		monitor.lock();		
		while (car.isBusy()) {
			try {
				condNotBusy.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		car.setBusy(true);
		monitor.unlock();
	}
	
	public void freeCar (Car car) {
		monitor.lock();
		car.setBusy(false);
		condNotBusy.signalAll();
		monitor.unlock();
	}
	
	public void goToWorkstation (WorkStation origin, WorkStation destination, Car car) {
		takeCar(car);		
		Position finalPos = origin.getPath();
		goTo(finalPos, car, origin);
		finalPos = destination.getPath();
		goTo(finalPos, car, destination);
		freeCar(car);
	}
	
	public void park (Parking parking, Car car) {
		takeCar(car);
		Position finalPos = parking.getPath();
		goTo(finalPos, car, parking);
		freeCar(car);
	}
	
	public void goTo(Position finalPos, Car car, Position position) {
		Position currentPos, nextPos = null;
		
		ensureItsInPath(car);
		
		while(car.getCurrentPos() != finalPos){
			currentPos = car.getCurrentPos();
			if(nextPos == null) {
				nextPos = askNextPos(currentPos,finalPos);
				System.out.println("Car " + car.getId() +
						" Current: " + currentPos.getRow() + currentPos.getNum() +
						" Next: " + nextPos.getRow() + nextPos.getNum());
				if (nextPos == finalPos) {
					if (position instanceof WorkStation)
						((WorkStation) position).take(Controller.this, car);
				}
			}else {
				nextPos.take();
				changePosition(nextPos, car);
				nextPos = null;
			}
		}
		System.out.println("Car " + car.getId() +
				" Current: " + car.getCurrentPos().getRow() + car.getCurrentPos().getNum());
		changePosition(position, car);
		
		System.out.println("Car " + car.getId() + " in " +
				car.getCurrentPos().getRow() + car.getCurrentPos().getNum());
	}
	
	public void changePosition (Position newPos, Car car) {
		car.getCurrentPos().free();
		car.setCurrentPos(newPos);
	}
	
	public void ensureItsInPath (Car car) {
		if (car.getCurrentPos() instanceof WorkStation)
			((WorkStation) car.getCurrentPos()).leave();
		else if (car.getCurrentPos() instanceof Parking)
			((Parking) car.getCurrentPos()).leave();
	}
	
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
	
	public synchronized Parking chooseBestParking (Car car, String row, int num) {
		String parkingRow = "";
		int parkingNum = num;
		Parking parking;
		
		if (row.equals("AW")) {
			parking = carInRowA(num, parkingRow, parkingNum);
		}else {
			parking = carInRowB(num, parkingRow, parkingNum);
		}
		parking.setCar(car);
			
		return parking;
	}
	
	public Parking carInRowA (int num, String parkingRow, int parkingNum) {
		boolean available;
		boolean bool = (num == 0)?true:false;
		
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
	
	public Parking carInRowB (int num, String parkingRow, int parkingNum) {
		boolean available;
		boolean bool = (num == 2)?true:false;
		
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
	
	public boolean seeParkingAvailability (String row, int num) {
		Parking parking = objects.getParking(row, num);
		
		return parking.available();		
	}

	public void createTaskToPark(Car car, WorkStation workstation) {
		threads.createTaskToPark(car, workstation);		
	}	
}
