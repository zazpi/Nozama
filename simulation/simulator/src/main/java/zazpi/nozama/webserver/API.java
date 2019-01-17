package zazpi.nozama.webserver;

import static spark.Spark.get;

import java.util.List;

import zazpi.nozama.simulation.App;
import zazpi.nozama.simulation.Car;
import zazpi.nozama.simulation.Controller;
import zazpi.nozama.simulation.Objects;
import zazpi.nozama.simulation.Threads;

public class API {
    private Objects obj;
    private Controller cont;
    private Threads th;
    private App simulator;
    private List<Car> cars;

    public void startup() {
		obj = new Objects();
		cont = new Controller(obj);
		th = new Threads(cont);
		simulator = new App(obj,cont,th);
		cars = simulator.getObj().getCars();
		simulator.createObjects();
    }

    public void registerEndpoints() {
        get("/hello", (req, res) -> {
            return Utils.getCarsPositions(cars);
        }, new JsonTransformer());
        get("/newOrder/:id", (req, res) -> {
        	System.out.println("fjsadñlfjksjfksdj");
        	return "requested order: " + req.queryParams("id");
        }, new JsonTransformer());
    }
}
