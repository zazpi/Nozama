package zazpi.nozama.simulation;

import java.util.logging.Logger;

public class Util {
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	private Util () {}
	
	public static void safeSleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			LOGGER.severe("Exception: " + e.getMessage());
		}
	}
}
