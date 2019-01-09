package nozama.simulation;

public class Util {
	
	public static void safeSleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
