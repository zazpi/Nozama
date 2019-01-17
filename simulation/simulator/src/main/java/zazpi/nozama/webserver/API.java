package zazpi.nozama.webserver;
import static spark.Spark.get;

import java.util.List;

import zazpi.nozama.simulation.App;
import zazpi.nozama.simulation.Car;
import zazpi.nozama.simulation.Controller;
import zazpi.nozama.simulation.Objects;
import zazpi.nozama.simulation.Threads;

public class API {
    private List<Car> cars;
	
    public void startup() {
		Objects obj = new Objects();
		Controller cont = new Controller(obj);
		Threads th = new Threads(cont);
		App simulator = new App(obj,cont,th);
		cars = simulator.getObj().getCars();
		simulator.setUpLogger();
		simulator.createObjects();
    }

    public void registerEndpoints() {
        get("/rb-data", (req,resp) -> {
            return Utils.getCarsPositions(cars);
        }, new JsonTransformer());
    }
}
