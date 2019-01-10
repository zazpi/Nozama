package nozama.simulation;

import java.util.ArrayList;
import java.util.List;

public class Controller {
	public static int NUM_CARS = 4;
	public static int NUM_POSITIONS = 5;
	public static int NUM_WORKSTATIONS = 6;
	List<Position> positions;
	List<WorkStation> workstations;
	List<Car> cars;
	
	public Position getPosition (String row, int num) {
		for (Position p : positions) {
			if (row.equals(p.getRow()) && num == p.getNum())
				return p;
		}
		return null;
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
		
		return getPosition(row, num);
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
		
		return getPosition(row, num);
	}
	
	public void getOrder() {
		
	}
	
	public void createCars() {
		cars = new ArrayList<>();
		cars.add(new Car(0,positions.get(0)));
		cars.add(new Car(1,positions.get(10)));
		positions.get(0).available = false;
		Thread th = new Task(0,cars.get(0),this,workstations.get(3),workstations.get(3));
		th.start();		
		
		Util.safeSleep(2000);
		
		Thread th2 = new Task(1,cars.get(1),this,workstations.get(4),workstations.get(3));
		th2.start();
	}
	
	public void createPositions() {
		//paths
		positions = new ArrayList<>();
		for(int i = 0; i < NUM_POSITIONS; i++)
			positions.add(new Position("A", i,true));
		for(int i = 0; i < NUM_POSITIONS; i++)
			positions.add(new Position("B", i,true));
		for(int i = 0; i < NUM_POSITIONS+1; i++)
			positions.add(new Position("AB", i,true));
		
		//workstations
		workstations = new ArrayList<>();
		workstations.add(new WorkStation("AW", 0, true, positions.get(0)));
		workstations.add(new WorkStation("AW", 1, true, positions.get(2)));
		workstations.add(new WorkStation("AW", 2, true, positions.get(4)));
		workstations.add(new WorkStation("BW", 0, true, positions.get(5)));
		workstations.add(new WorkStation("BW", 1, true, positions.get(7)));
		workstations.add(new WorkStation("BW", 2, true, positions.get(9)));
		
		//parkings
	}
	
	
}
