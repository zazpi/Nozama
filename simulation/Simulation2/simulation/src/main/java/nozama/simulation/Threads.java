package nozama.simulation;

import java.util.ArrayList;
import java.util.List;

public class Threads {
	Controller controller;
	Objects objects;
	
	List<Task> tasks;
	List<Park> tasksToPark;
	List<Thread> threadsTasks, threadsTasksToPark;
	int idTask, idTaskToPark;
	
	public Threads (Controller controller, Objects objects) {
		this.controller = controller;
		this.objects = objects;
		idTask = 0;
		idTaskToPark = 0;
		tasks = new ArrayList<>();
		tasksToPark = new ArrayList<>();
		threadsTasks = new ArrayList<>();
		threadsTasksToPark = new ArrayList<>();
	}
	
	public Task getTask (int id) {
		for (Task t : tasks) {
			if (id == t.getId())
				return t;
		}
		return null;
	}
	
	public Park getTaskToPark (int id) {
		for (Park p : tasksToPark) {
			if (id == p.getId())
				return p;
		}
		return null;
	}
	
	public synchronized void createTasks (Car car, WorkStation origin, WorkStation destination) {
		tasks.add(new Task(idTask, car, controller, origin, destination));
		threadsTasks.add(new Thread(tasks.get(idTask)));
		threadsTasks.get(idTask).start();
		idTask++;
	}
	
	public void removeTasks (int id) {
		try {
			threadsTasks.get(id).join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		threadsTasks.remove(getTask(id));
		tasks.remove(getTask(id));
		
		idTask--;
	}
	
	public synchronized void createTaskToPark (Car car, WorkStation workstation) {
		Parking parking = controller.chooseBestParking(car, workstation.getRow(), workstation.getNum());
		
		tasksToPark.add(new Park(idTaskToPark, car, controller, parking));
		threadsTasksToPark.add(new Thread(tasksToPark.get(idTaskToPark)));
		threadsTasksToPark.get(idTaskToPark).start();
		idTaskToPark++;
	}
	
	public void removeTasksToPark (int id) {
		try {
			threadsTasksToPark.get(id).join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		threadsTasksToPark.remove(getTaskToPark(id));
		tasksToPark.remove(getTaskToPark(id));
		
		idTaskToPark--;
	}
}
