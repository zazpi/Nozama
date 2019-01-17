package zazpi.nozama.simulation;

import java.util.ArrayList;
import java.util.List;

/**
 * Here we have the different objects the app will use
 **/
public class Objects {
	/**
	 * @param num_cars The number of cars
	 * @param num_positions The number of columns of the paths
	 * @param positions The list of the different paths
	 * @param workstations The list of the workstations
	 * @param parkings The list of the parkings
	 * @param cars The list of the cars
	 **/
	public static final int NUM_CARS = 5;
	public static final int NUM_POSITIONS = 5;
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
	
	/**
	 * Get a specific position depending on where it is
	 * @param row
	 * @param column
	 * @return position
	 **/
	public Position getPosition (String row, int num) {
		for (Position p : positions) {
			if (row.equals(p.getRow()) && num == p.getNum())
				return p;
		}
		return null;
	}
	
	/**
	 * Get a specific parking depending on where it is
	 * @param row
	 * @param column
	 * @return parking
	 **/
	public Parking getParking (String row, int num) {
		for (Parking p : parkings) {
			if (row.equals(p.getRow()) && num == p.getNum())
				return p;
		}
		return null;
	}
	
	/**
	 * Get a specific workstation depending where it is
	 * @param row
	 * @param column
	 * @return workstation
	 **/
	public WorkStation getWorkstation (String row, int num) {
		for (WorkStation w : workstations) {
			if (row.equals(w.getRow()) && num == w.getNum())
				return w;
		}
		return null;
	}
	
	/**
	 * Creation of the different paths, workstations and parkings
	 **/
	public void createPositions() {
		for(int i = 0; i < NUM_POSITIONS; i++)
			positions.add(new Position("A", i,true));
		for(int i = 0; i < NUM_POSITIONS; i++)
			positions.add(new Position("B", i,true));
		for(int i = 0; i < NUM_POSITIONS+1; i++)
			positions.add(new Position("AB", i,true));
		
		workstations.add(new WorkStation("AW", 0, true, positions.get(0)));
		workstations.add(new WorkStation("AW", 1, true, positions.get(2)));
		workstations.add(new WorkStation("AW", 2, true, positions.get(4)));
		workstations.add(new WorkStation("BW", 0, true, positions.get(5)));
		workstations.add(new WorkStation("BW", 1, true, positions.get(7)));
		workstations.add(new WorkStation("BW", 2, true, positions.get(9)));
		
		parkings.add(new Parking("AP", 0, true, positions.get(1)));
		parkings.add(new Parking("AP", 1, true, positions.get(3)));
		parkings.add(new Parking("BP", 0, true, positions.get(6)));
		parkings.add(new Parking("BP", 1, true, positions.get(8)));	
	}
	
	/**
	 * Creation of the cars. They have assigned a workstation by default, this means that
	 * the workstations will have a car and that they will be unavailabled
	 **/
	public void createCars() {
		for (int i=0;i<NUM_CARS;i++) {
			cars.add(new Car(i,workstations.get(i)));
			workstations.get(i).setCar(cars.get(i));
			workstations.get(i).take();
		}
	}
	
	/**
	 * Get the list of the cars
	 * @return cars
	 **/
	public List<Car> getCars() {
		return cars;
	}
}
