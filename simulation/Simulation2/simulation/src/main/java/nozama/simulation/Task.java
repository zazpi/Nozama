package nozama.simulation;

public class Task extends Thread {
	int id;
	Controller controller;
	Car car;
	Position nextPos;
	WorkStation aPos, bPos;
	
	public Task(int id,Car car,Controller controller, WorkStation aPos, WorkStation bPos) {
		this.id = id;
		this.car = car;
		this.controller = controller;
		this.aPos = aPos;
		this.bPos = bPos;
	}

	public void run() {
		System.out.println("Task started");
		car.setBusy(true);
		
		goTo(aPos);
		goTo(bPos);
		car.setBusy(false);
	}
	
	public void goTo(WorkStation workstation) {
		Position currentPos;
		Position finalPos = workstation.getPath();
		
		ensureItsInPath();
		
		while(car.getCurrentPos() != finalPos){
			currentPos = car.getCurrentPos();
			if(nextPos == null) {
				nextPos = controller.askNextPos(currentPos,finalPos);
				System.out.println("Car " + car.getId() +
						" Current: " + currentPos.getRow() + currentPos.getNum() +
						" Next: " + nextPos.getRow() + nextPos.getNum());
				if (nextPos == finalPos) workstation.take();
			}else {
				nextPos.take();
				changePosition(nextPos);
			}
		}
		changePosition(workstation);
		
		System.out.println("Finish go to car " + car.getId());
	}
	
	public void changePosition (Position newPos) {
		car.getCurrentPos().free();
		car.setCurrentPos(newPos);
		nextPos = null;
	}
	
	public void ensureItsInPath () {
		if (car.getCurrentPos() instanceof WorkStation)
			((WorkStation) aPos).leave(car);
	}
	
}
