package zazpi.nozama.simulation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class GetListTest {
	Objects objects;
	Threads threads;
	Controller controller;
	Parking parking;
	Position posW, posP;
	WorkStation workstation;
	
	@Before
	public void createListsObjects () {
		objects = new Objects();
		objects.createPositions();
		controller = new Controller(objects);
		threads = new Threads(controller);
		posP = new Position("B", 1, true);
		parking = new Parking("BP", 1, true, posW);
		posW = new Position("B", 4, true);
		workstation = new WorkStation("BW", 2, true, posW);
	}
	@Test
	public void getListInObjectsTest () {
		Parking p = objects.getParking("BP", 1);
		assertEquals(parking, p);
		WorkStation w = objects.getWorkstation("BW", 2);
		assertEquals(workstation, w);
		Position pos = objects.getPosition("B", 1);
		assertEquals(posP, pos);
	}
	
	@Test
	public void getListNullInObjectsTest () {
		Parking p = objects.getParking("PB", 0);
		assertNull(p);
		WorkStation w = objects.getWorkstation("BW", 10);
		assertNull(w);
		Position pos = objects.getPosition("C", 0);
		assertNull(pos);
	}	
}
