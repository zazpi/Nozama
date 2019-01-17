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
		position = new Position("A", 5, true);
		car = new Car(5, position);
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
	
	@Test
	public void changePositionTest () {
		Position newPos = new Position("AB", 6, true);
		assertEquals(position, car.getCurrentPos());
		controller.changePosition(newPos, car);
		assertTrue(position.available());
		assertEquals(newPos, car.getCurrentPos());
	}
	
	Parking parking;
	WorkStation workstation;
	Position position1;
	
	@Before
	public void prepareEnsureItsInPathTest () {
		position1 = new Position("A", 6, true);
		parking = new Parking("AP", 2, false, position1);
		workstation = new WorkStation("AW", 3, false, position);
	}
	@Test
	public void ensureItsInPathTestFromParking () {
		car.setCurrentPos(parking);
		parking.setCar(car);
		controller.ensureItsInPath(car);
		assertEquals(position1, car.getCurrentPos());
		assertTrue(parking.available());
	}	
	@Test
	public void ensureItsInPathTestFromWorkstation () {
		car.setCurrentPos(workstation);
		workstation.setCar(car);
		controller.ensureItsInPath(car);
		assertEquals(position, car.getCurrentPos());
		assertTrue(workstation.available());
	}
	@Test
	public void ensureItsInPathTestFromPath () {
		Position pos = new Position("B", 5, true);
		car.setCurrentPos(pos);
		controller.ensureItsInPath(car);
		assertEquals(pos, car.getCurrentPos());
	}
	
	Parking ap0, ap1, bp0, bp1;
	WorkStation aw0, aw1, aw2, bw0, bw1, bw2;
	
	@Before
	public void prepareChooseBestParkingTest () {
		ap0 = new Parking("AP", 0, true, new Position("A",1,true));
		ap1 = new Parking("AP", 1, true, new Position("A",3,true));
		bp0 = new Parking("BP", 0, true, new Position("B",1,true));
		bp1 = new Parking("BP", 1, true, new Position("B",3,true));
		aw0 = new WorkStation("AW",0,false,new Position("A",0,true));
		aw1 = new WorkStation("AW",1,false,new Position("A",2,true));
		aw2 = new WorkStation("AW",2,false,new Position("A",4,true));
		bw0 = new WorkStation("BW",0,false,new Position("B",0,true));
		bw1 = new WorkStation("BW",1,false,new Position("B",2,true));
		bw2 = new WorkStation("BW",2,false,new Position("B",4,true));
	}
	
	@Test
	public void carInAW0ChooseBestParkingTest () {
		car = new Car(0, aw0);
		assertEquals(bp0,controller.chooseBestParking(car, "AW", 0));
		assertEquals(bp1, controller.chooseBestParking(car, "AW", 0));
		assertEquals(ap0, controller.chooseBestParking(car, "AW", 0));
		assertEquals(ap1, controller.chooseBestParking(car, "AW", 0));
	}	
	@Test
	public void carInAW1ChooseBestParkingTest () {
		car = new Car(0, aw1);
		assertEquals(ap0,controller.chooseBestParking(car, "AW", 1));
		assertEquals(bp1, controller.chooseBestParking(car, "AW", 1));		
		assertEquals(bp0, controller.chooseBestParking(car, "AW", 1));
		assertEquals(ap1, controller.chooseBestParking(car, "AW", 1));
	}
	@Test
	public void carInAW2ChooseBestParkingTest () {
		car = new Car(0, aw2);
		assertEquals(ap1,controller.chooseBestParking(car, "AW", 2));
		assertEquals(ap0, controller.chooseBestParking(car, "AW", 2));		
		assertEquals(bp1, controller.chooseBestParking(car, "AW", 2));
		assertEquals(bp0, controller.chooseBestParking(car, "AW", 2));
	}
	
	@Test
	public void carInBW0ChooseBestParkingTest () {
		car = new Car(0, bw0);
		assertEquals(bp0,controller.chooseBestParking(car, "BW", 0));
		assertEquals(bp1, controller.chooseBestParking(car, "BW", 0));
		assertEquals(ap0, controller.chooseBestParking(car, "BW", 0));
		assertEquals(ap1, controller.chooseBestParking(car, "BW", 0));
	}	
	@Test
	public void carInBW1ChooseBestParkingTest () {
		car = new Car(0, bw1);
		assertEquals(bp1, controller.chooseBestParking(car, "BW", 1));
		assertEquals(ap0, controller.chooseBestParking(car, "BW", 1));
		assertEquals(ap1, controller.chooseBestParking(car, "BW", 1));
		assertEquals(bp0, controller.chooseBestParking(car, "BW", 1));
	}	
	@Test
	public void carInBW2ChooseBestParkingTest () {
		car = new Car(0, bw2);
		assertEquals(ap1, controller.chooseBestParking(car, "BW", 2));
		assertEquals(ap0, controller.chooseBestParking(car, "BW", 2));
		assertEquals(bp1, controller.chooseBestParking(car, "BW", 2));
		assertEquals(bp0, controller.chooseBestParking(car, "BW", 2));
	}

}
