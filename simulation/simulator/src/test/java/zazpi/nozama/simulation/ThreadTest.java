package zazpi.nozama.simulation;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ThreadTest {
	Threads threads;
	Objects objects;
	Controller controller;
	Car car;
	WorkStation origin, destination;
	Position position;
	
	@Before
	public void createParkThread () {
		objects = new Objects();
		objects.createPositions();
		objects.createCars();
		controller = new Controller(objects);
		threads = new Threads(controller);
		controller.setThreads(threads);
		position = new Position("A", 0, true);
		car = objects.getCars().get(0);
		origin = new WorkStation("BW", 0, true, objects.getPosition("B", 0));
		destination = new WorkStation("AW", 2, true, objects.getPosition("A", 4));
	}
	@Test
	public void checkTaskToParkCreationTest () {
		threads.createTaskToPark(car, origin);
		assertEquals(1, threads.idTaskToPark);
		threads.removeTasksToPark(0);
		assertEquals(0, threads.idTaskToPark);
		assertEquals(car.getCurrentPos(), objects.getParking("BP", 0));
	}
	
	@Test
	public void checkTaskCreationTest () {
		threads.createTasks(0, 0, origin, destination);
		assertEquals(1, threads.idTask);
		threads.removeTasks(0);
		assertEquals(0, threads.idTask);
		assertEquals(car.getCurrentPos(), destination);
	}
}
