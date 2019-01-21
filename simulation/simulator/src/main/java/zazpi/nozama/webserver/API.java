package zazpi.nozama.webserver;
import static spark.Spark.get;

import java.util.List;
import java.util.logging.Logger;

import zazpi.nozama.simulation.App;
import zazpi.nozama.simulation.Car;
import zazpi.nozama.simulation.Controller;
import zazpi.nozama.simulation.Objects;
import zazpi.nozama.simulation.Threads;

public class API {
	private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	App simulator;
    private List<Car> cars;
	
    public void startup() {
		Objects obj = new Objects();
		Controller cont = new Controller(obj);
		Threads th = new Threads(cont);
		simulator = new App(obj,cont,th);
		cars = simulator.getObj().getCars();
		simulator.setUpLogger();
		simulator.createObjects();
    }

    public void registerEndpoints() {
        get("/rb-data", (req,resp) -> {
            return Utils.getCarsPositions(cars);
        }, new JsonTransformer());
        get("/neworder", (req, resp) -> {
        	String suborder = req.queryParams("suborder");
        	String shelfs = req.queryParams("shelfs");
        	String products = req.queryParams("products");
        	simulator.newOrder(suborder, shelfs, products);
        	LOGGER.info(suborder + " - " + shelfs + " " + products);
        	return "ok" + suborder + " - " + shelfs + " " + products;
        }, new JsonTransformer());
    }
}
