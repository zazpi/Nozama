package zazpi.nozama.simulation;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * This is the class that creates and deletes all the threads
 */
public class Threads {
	/**
	 * @param controller: Reference to class Controller which does all the movements
	 * @param tasks: the list of tasks created. These are the ones that will move from
	 * 		a workstation to another
	 * @param tasksToPark: the list of tasks to park created. These are the ones that will
	 * 		leave a workstation and move to a parking
	 * @param threadsTasks: the creation of the thread of the tasks
	 * @param threadsTasksToPark: the creation of the threads of the tasks to park
	 * @param idTask: it indicates the number of active tasks
	 * @param idTaskToPark: it indicates the number of active tasks to park
	 **/
	private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	Controller controller;	
	List<Task> tasks;
	List<Park> tasksToPark;
	List<Thread> threadsTasks;
	List<Thread> threadsTasksToPark;
	int idTask;
	int idTaskToPark;
	
	public Threads (Controller controller) {
		this.controller = controller;
		idTask = 0;
		idTaskToPark = 0;
		tasks = new ArrayList<>();
		tasksToPark = new ArrayList<>();
		threadsTasks = new ArrayList<>();
		threadsTasksToPark = new ArrayList<>();
	}
	
	/**
	 * Get a task depending of its id
	 * @param id
	 * @return task
	 **/
	public Task getTask (int id) {
		for (Task t : tasks) {
			if (id == t.getId())
				return t;
		}
		return null;
	}
	/**
	 * Get a task thread depending of its name
	 * @param id
	 * @return thread
	 */
	public Thread getTaskThread (int id) {
		for (Thread th : threadsTasks) {
			if (Integer.toString(id).equals(th.getName()))
				return th;
		}
		return null;
	}
	
	/**
	 * Get a task to park depending of its id
	 * @param id
	 * @return taskToPark
	 */
	public Park getTaskToPark (int id) {
		for (Park p : tasksToPark) {
			if (id == p.getId())
				return p;
		}
		return null;
	}
	/**
	 * Get a task to park thread depending of its name
	 * @param id
	 * @return thread
	 */
	public Thread getTaskToParkThread (int id) {
		for (Thread th : threadsTasksToPark) {
			if (Integer.toString(id).equals(th.getName()))
				return th;
		}
		return null;
	}
	
	/**
	 * It will create a thread to move a car from a workstation to another
	 * @param car
	 * @param origin workstation
	 * @param destination workstation
	 */
	public synchronized void createTasks (Car car, WorkStation origin, WorkStation destination) {
		tasks.add(new Task(idTask, car, controller, origin, destination));
		threadsTasks.add(new Thread(tasks.get(idTask), Integer.toString(idTask)));
		threadsTasks.get(idTask).start();
		idTask++;
	}
	/**
	 * After finishing a thread, this will be deleted
	 * @param id
	 */
	public void removeTasks (int id) {
		try {
			threadsTasks.get(id).join();
		} catch (InterruptedException e) {
			LOGGER.severe("Exception: " + e.getMessage());
			Thread.currentThread().interrupt();
		}
		threadsTasks.remove(getTaskThread(id));
		tasks.remove(getTask(id));
		
		idTask--;
	}
	
	/**
	 * It will create a thread to leave a workstation and move the car to a parking after
	 * choosing it
	 * @param car
	 * @param workstation
	 */
	public synchronized void createTaskToPark (Car car, WorkStation workstation) {
		Parking parking = controller.chooseBestParking(car, workstation.getRow(), workstation.getNum());
		
		tasksToPark.add(new Park(idTaskToPark, car, controller, parking));
		threadsTasksToPark.add(new Thread(tasksToPark.get(idTaskToPark), Integer.toString(idTaskToPark)));
		threadsTasksToPark.get(idTaskToPark).start();
		idTaskToPark++;
	}
	/**
	 * After finishing a thread, this will be deleted
	 * @param id
	 */
	public void removeTasksToPark (int id) {
		try {
			threadsTasksToPark.get(id).join();
		} catch (InterruptedException e) {
			LOGGER.severe("Exception: " + e.getMessage());
			Thread.currentThread().interrupt();
		}
		threadsTasksToPark.remove(getTaskToParkThread(id));
		tasksToPark.remove(getTaskToPark(id));
		
		idTaskToPark--;
	}
	
	/**
	 * Get the number of active threads of task
	 * @return idTask
	 */
	public int getIdTask() {
		return idTask;
	}
	
	/**
	 * Get the number of active threads of task to park
	 * @return idTaskToPark
	 */
	public int getIdTaskToPark() {
		return idTaskToPark;
	}
}
