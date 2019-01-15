package zazpi.nozama.simulation;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Objects obj = new Objects();
        Controller cont = new Controller(obj);
        Threads th = new Threads(cont, obj);
        cont.setThreads(th);
        obj.createPositions();
        obj.createCars();
        
        //tareak eskaera bat dagoenean sortuko dira
        th.createTasks(obj.cars.get(0), obj.workstations.get(3), obj.workstations.get(2));	
		th.createTasks(obj.cars.get(1), obj.workstations.get(0), obj.workstations.get(5));
		th.createTasks(obj.cars.get(2), obj.workstations.get(4), obj.workstations.get(0));
		th.createTasks(obj.cars.get(3), obj.workstations.get(4), obj.workstations.get(3));
		th.createTasks(obj.cars.get(4), obj.workstations.get(2), obj.workstations.get(5));
		
		
        //remove threads (proba)		
		for (int i=0;i<th.idTask;i++) {
			th.removeTasks(i);
		}
		Util.safeSleep(1000);
		for (int i=0;i<th.idTaskToPark;i++) {
        	th.removeTasksToPark(i);
        }
        
        System.out.println("Everything was better than expected");
    }
}
