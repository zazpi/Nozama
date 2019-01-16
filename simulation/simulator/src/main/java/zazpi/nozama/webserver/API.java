package zazpi.nozama.webserver;

import zazpi.nozama.simulation.*;

import java.util.List;

import static spark.Spark.get;

public class API {
    private Objects obj;
    private Controller cont;
    private Threads th;
    private App simulator;
    private List<Car> cars;

    public API() {
    }

    public void startup() {

        obj = new Objects();
         cont = new Controller(obj);
         th = new Threads(cont, obj);
         simulator = new App(obj,cont,th);
        cars = simulator.getObj().getCars();
        simulator.createObjects();
    }

    public void registerEndpoints() {
        get("/hello", (req, res) -> {
            return Utils.getCarsPositions(cars);
        }, new JsonTransformer());
    }
}
