package zazpi.nozama.simulation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

public class ControllerTest {
	

	@RunWith(Parameterized.class)
	public static class nextPositionTest {
		@Parameters
		public static Collection<Object[]> data() {
	        return Arrays.asList(new Object[][] {     
                {new Position("A",2,true),new Position("A",4,true),new Position("AB",2,true)},
                {new Position("A",1,true),new Position("A",2,true),new Position("A",0,true)},
                {new Position("A",3,true),new Position("A",1,true),new Position("A",2,true)},   
                {new Position("B",2,true),new Position("B",0,true),new Position("AB",3,true)},
                {new Position("B",0,true),new Position("B",2,true),new Position("B",1,true)},
                {new Position("B",3,true),new Position("B",1,true),new Position("B",4,true)},
                
                {new Position("AB",1,true),new Position("B",1,true),new Position("A",0,true)},
                {new Position("AB",2,true),new Position("B",1,true),new Position("B",2,true)},
                {new Position("A",2,true),new Position("B",1,true),new Position("A",1,true)},
                {new Position("A",2,true),new Position("B",2,true),new Position("AB",2,true)},
                {new Position("A",1,true),new Position("B",2,true),new Position("A",0,true)},
                {new Position("B",2,true),new Position("A",1,true),new Position("AB",3,true)},
                {new Position("B",3,true),new Position("A",2,true),new Position("B",4,true)},
                {new Position("B",1,true),new Position("A",2,true),new Position("B",2,true)}
          });
		}
		
		Position pCurrent,pGoal,pResult;
		
		public nextPositionTest (Position pCurrent, Position pGoal, Position pResult) {
			this.pCurrent = pCurrent;
			this.pGoal = pGoal;
			this.pResult = pResult;
		}
		Controller controller;
		Objects objects;
		@Before
		public void before() {
			objects = new Objects();
			objects.createPositions();
			controller = new Controller(objects);
		}
		
		@Test
		public void askNextPosTest() {
			assertEquals(pResult,controller.askNextPos(pCurrent, pGoal));
		}
		
	}
	
	Controller controller;
	Objects objects;
	
	@Before
	public void prepareGetPositionTest () {
		objects = new Objects();
		objects.createPositions();
		controller = new Controller(objects);
	}	
	@Test
	public void getPositionTest() {
		String randomRow = "A";
		int randomNum = (new Random()).nextInt(5);
		Position pos = new Position(randomRow, randomNum, true);
		assertEquals(pos,objects.getPosition(randomRow, randomNum));
	}
	
	Car car;
	Position position;
	@Before
	public void prepareCarTest () {
		position = new Position("A", 0, true);
		car = new Car(0, position);
		car.setBusy(false);
	}
	@Test
	public void takeNotBusyCarTest () {
		controller.takeCar(car);
		assertTrue(car.isBusy());
	}
	@Test
	public void freeCarTest () {
		controller.freeCar(car);
		assertFalse(car.isBusy());
	}
	
	@RunWith(Parameterized.class)
	public static class chooseBestParkingTest {
		@Parameters
		public static Collection<Object[]> data() {
	        return Arrays.asList(new Object[][] {
	        	// car in BW0
                {new Car(0, new WorkStation("BW",0,false,new Position("B",0,true))),
                	"BW",0, new Parking("BP",0,true,new Position("B",1,true))},
                {new Car(0, new WorkStation("BW",0,false,new Position("B",0,true))),
                    	"BW",0, new Parking("BP",1,true,new Position("B",3,true))},
                {new Car(0, new WorkStation("BW",0,false,new Position("B",0,true))),
                        	"BW",0, new Parking("AP",0,true,new Position("A",1,true))},
                {new Car(0, new WorkStation("BW",0,false,new Position("B",0,true))),
                            	"BW",0, new Parking("AP",1,true,new Position("A",3,true))}            	
          });
		}
		
		Car car;
		String workstatioRow;
		int workstatioNum;
		Parking pResult;
		
		public chooseBestParkingTest (Car car, String workstationRow, int workstationNum,
				Parking pResult) {
			this.car = car;
			this.workstatioRow = workstationRow;
			this.workstatioNum = workstationNum;
			this.pResult = pResult;
		}
		
		Controller controller;
		Objects objects;
		Parking parking1, parking2, parking3;
		@Before
		public void before() {
			objects = new Objects();
			objects.createPositions();
			controller = new Controller(objects);
		}
		
		@Test
		public void allParkingFreeTest () {
			assertEquals(pResult,controller.chooseBestParking(car, workstatioRow, workstatioNum));
		}
		
		@Test
		public void firstParkingOccupiedTest () {
			parking1 = objects.getParking("BP", 0);
			parking1.take();
			assertEquals(pResult,controller.chooseBestParking(car, workstatioRow, workstatioNum));
		}
		
		@Test
		public void secondParkingOccupiedTest () {
			parking1 = objects.getParking("BP", 0);
			parking1.take();
			parking2 = objects.getParking("BP", 1);
			parking2.take();
			assertEquals(pResult,controller.chooseBestParking(car, workstatioRow, workstatioNum));
		}
		
		@Test
		public void thirdParkingOccupiedTest () {
			parking1 = objects.getParking("BP", 0);
			parking1.take();
			parking2 = objects.getParking("BP", 1);
			parking2.take();
			parking3 = objects.getParking("AP", 0);
			parking3.take();
			assertEquals(pResult,controller.chooseBestParking(car, workstatioRow, workstatioNum));
		}
	}

}
