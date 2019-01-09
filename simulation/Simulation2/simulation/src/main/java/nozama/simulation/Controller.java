package nozama.simulation;

import java.util.ArrayList;
import java.util.List;

public class Controller {
	public static int NUM_CARS = 4;
	public static int NUM_POSITIONS = 15;
	List<Position> positions;
	List<Car> cars;

	/*public Position askNextPos(Position currentPos, Position finalPos) {
		if(currentPos == finalPos) return currentPos;
		else {
			int p = currentPos.getId();
			p = (p+1) % NUM_POSITIONS;
			return getPosition(p);
		}
	}
	
	public Position getPosition (int id) {
		for(Position p : positions){
			if(p.getId() == id)
				return p;
		}
		return null;
	}*/
	
	public Position askNextPos(Position currentPos, Position finalPos) {
		int nA = currentPos.getNum();
		int nB = finalPos.getNum();
		String rA = currentPos.getRow();
		String rB = finalPos.getRow();
		
		//if(rA.equals(rB))
		return null;	
		
	}
	
	/*public Position sameRow(String row, int currentNum, int finalNum) {
		int num;
		num = currentNum + ((currentNum > finalNum)?1:-1);
	}*/
	
	public void getOrder() {
		
	}
	
	public void createCars() {
		cars = new ArrayList<>();
		cars.add(new Car(0,positions.get(0)));
		cars.add(new Car(1,positions.get(4)));
		positions.get(0).available = false;
		positions.get(4).available = false;
		Thread th = new Task(0,cars.get(0),this,positions.get(2),positions.get(10));
		th.start();

		Thread th2 = new Task(1,cars.get(1),this,positions.get(9),positions.get(9));
		th2.start();
	}
	
	public void createPositions() {
		positions = new ArrayList<>();
		/*for(int i = 0; i < NUM_POSITIONS; i++)
			positions.add(new Position(i,true));*/
	}
	
	
}
