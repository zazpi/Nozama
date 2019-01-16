package zazpi.nozama.simulation;

/**
 * Hello world!
 *
 */
public class App 
{
    public Objects obj;
    public Controller controller;
    public Threads threads;

    public App(Objects obj, Controller controller, Threads threads) {
        this.obj = obj;
        this.controller = controller;
        this.threads = threads;
    }

    public void createObjects()
    {
        System.out.println( "Hello World!" );
        controller.setThreads(threads);
        obj.createPositions();
        obj.createCars();
        
        //tareak eskaera bat dagoenean sortuko dira
        threads.createTasks(obj.cars.get(0), obj.workstations.get(3), obj.workstations.get(2));
		threads.createTasks(obj.cars.get(1), obj.workstations.get(0), obj.workstations.get(5));
		threads.createTasks(obj.cars.get(2), obj.workstations.get(4), obj.workstations.get(0));
		threads.createTasks(obj.cars.get(3), obj.workstations.get(4), obj.workstations.get(3));
		threads.createTasks(obj.cars.get(4), obj.workstations.get(2), obj.workstations.get(5));
        
        System.out.println("Everything was better than expected");
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
