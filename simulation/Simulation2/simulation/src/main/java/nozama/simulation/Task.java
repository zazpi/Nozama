package nozama.simulation;

public class Task extends Thread {
	int id;
	Controller controller;
	Car car;
	Position nextPos, aPos, bPos;
	
	public Task(int id,Car car,Controller controller,Position aPos,Position bPos) {
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
	
	public void goTo(Position finalPos) {
		Position currentPos;
		while(car.getCurrentPos() != finalPos){
			currentPos = car.getCurrentPos();
			if(nextPos == null) {
				nextPos = controller.askNextPos(currentPos,finalPos);
			}else {
				System.out.println("Car " + car.getId() +
						" Current: " + currentPos.getRow() + currentPos.getNum() +
						" Next: " + nextPos.getRow() + nextPos.getNum());
				nextPos.take();
				currentPos.free();
				car.setCurrentPos(nextPos);
				nextPos = null;
			}
		}
		System.out.println("Finish go to car " + car.getId());
	}
	
}
