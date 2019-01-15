package zazpi.nozama.simulation;

import java.util.ArrayList;
import java.util.List;

public class Objects {
	public static int NUM_CARS = 5;
	public static int NUM_POSITIONS = 5;
	public static int NUM_WORKSTATIONS = 6;
	List<Position> positions;
	List<WorkStation> workstations;
	List<Parking> parkings;
	List<Car> cars;
	
	public Objects () {
		positions = new ArrayList<>();
		workstations = new ArrayList<>();
		parkings = new ArrayList<>();
		cars = new ArrayList<>();
	}
	
	public Position getPosition (String row, int num) {
		for (Position p : positions) {
			if (row.equals(p.getRow()) && num == p.getNum())
				return p;
		}
		return null;
	}
	
	public Parking getParking (String row, int num) {
		for (Parking p : parkings) {
			if (row.equals(p.getRow()) && num == p.getNum())
				return p;
		}
		return null;
	}
	
	public void createPositions() {
		//paths
		for(int i = 0; i < NUM_POSITIONS; i++)
			positions.add(new Position("A", i,true));
		for(int i = 0; i < NUM_POSITIONS; i++)
			positions.add(new Position("B", i,true));
		for(int i = 0; i < NUM_POSITIONS+1; i++)
			positions.add(new Position("AB", i,true));
		
		//workstations
		workstations.add(new WorkStation("AW", 0, true, positions.get(0)));
		workstations.add(new WorkStation("AW", 1, true, positions.get(2)));
		workstations.add(new WorkStation("AW", 2, true, positions.get(4)));
		workstations.add(new WorkStation("BW", 0, true, positions.get(5)));
		workstations.add(new WorkStation("BW", 1, true, positions.get(7)));
		workstations.add(new WorkStation("BW", 2, true, positions.get(9)));
		
		//parkings
		parkings.add(new Parking("AP", 0, true, positions.get(1)));
		parkings.add(new Parking("AP", 1, true, positions.get(3)));
		parkings.add(new Parking("BP", 0, true, positions.get(6)));
		parkings.add(new Parking("BP", 1, true, positions.get(8)));	
	}
	
	public void createCars() {//defektuz posizio bat
		for (int i=0;i<NUM_CARS;i++) {
			cars.add(new Car(i,workstations.get(i)));
			workstations.get(i).setCar(cars.get(i));
			workstations.get(i).take();
		}
	}
}
