package nozama.simulation;

import static org.junit.Assert.assertEquals;

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
                {new Position("B",0,true),new Position("B",1,true),new Position("B",1,true)},
                {new Position("B",0,true),new Position("B",1,true),new Position("B",1,true)},
                {new Position("B",0,true),new Position("B",1,true),new Position("B",1,true)},
                {new Position("B",0,true),new Position("B",1,true),new Position("B",1,true)}
          });
		}
		
		Position pCurrent,pGoal,pResult;
		
		public nextPositionTest (Position pCurrent, Position pGoal, Position pResult) {
			this.pCurrent = pCurrent;
			this.pGoal = pGoal;
			this.pResult = pResult;
		}
		Controller controller;
		@Before
		public void before() {
			controller = new Controller();
			controller.createPositions();
		}
		
		@Test
		public void sameRowTest() {

			assertEquals(pResult,controller.askNextPos(pCurrent, pGoal));
		}
		
	}
	
	Controller controller;
	
	@Before
	public void prepare() {
		controller = new Controller();
		controller.createPositions();
	}
	
	@Test
	public void getPositionTest() {
		String randomRow = "A";
		int randomNum = (new Random()).nextInt(controller.positions.size());
		Position pos = new Position(randomRow, randomNum, true);
		assertEquals(pos,controller.getPosition(randomRow, randomNum));
	}
	

}
