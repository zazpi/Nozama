package zazpi.nozama.simulation;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class App 
{
    private Objects obj;
    private Controller controller;
    private Threads threads;

    public App(Objects obj, Controller controller, Threads threads) {
        this.obj = obj;
        this.controller = controller;
        this.threads = threads;
    }

    public void createObjects() {
        controller.setThreads(threads);
        obj.createPositions();
        obj.createCars();
    }
    
    public void newOrder (String suborder, String shelfs, String products) {
    	int suborderId = Integer.parseInt(suborder);
    	String [] shelf = shelfs.split(",");
    	String [] product = products.split(",");
    	WorkStation workstation = null;
    	
		for (WorkStation w : obj.getWorkstations()) {
    		if (!w.isOrder()) {
    			w.setOrder(true);
    			workstation = w;
    			break;
    		}
    	}
		
		for (int i=0; i<shelf.length;i++) {
			Util.safeSleep(100);
			int shelfId = Integer.parseInt(shelf[i]);
			int productId = Integer.parseInt(product[i]);
			threads.createTasks(suborderId, productId, obj.getWorkstations().get(shelfId), workstation);
		}
    }
    
    public void setUpLogger () {
    	Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    	logger.setLevel(Level.INFO);
    	try {
			FileHandler fileTxt = new FileHandler("logging.txt");
			SimpleFormatter formatterTxt = new SimpleFormatter();
			fileTxt.setFormatter(formatterTxt);
			logger.addHandler(fileTxt);
		} catch (SecurityException | IOException e) {
			logger.info("Exception: " + e.getMessage());
		}
    }

    public Objects getObj() {
        return obj;
    }

    public Controller getController() {
        return controller;
    }

    public Threads getThreads() {
        return threads;
    }

}
