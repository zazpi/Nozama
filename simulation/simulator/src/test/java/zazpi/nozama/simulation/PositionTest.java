package zazpi.nozama.simulation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class PositionTest {
	Position position;
	WorkStation workstation;
	Car car, car1;
	Controller controller;
	Threads threads;
	Objects objects;
	
	@Before
	public void createPositions () {
		objects = new Objects();
		objects.createPositions();
		controller = new Controller(objects);
		threads = new Threads(controller);
		controller.setThreads(threads);
		
		position = objects.getPosition("A", 2);
		workstation = objects.getWorkstation("AW", 1);
		car = new Car(6, workstation);
		workstation.take(controller, car);
		car1 = new Car(7, new Position("A", 3, false));
	}
	
	@Test
	public void takeInWorkstationTest () {
		car.setBusy(false);
		controller.goTo(position, car1, workstation);
		threads.removeTasksToPark(0);
		assertEquals(car1, workstation.car);
		assertEquals(workstation, car1.getCurrentPos());
	}
}
