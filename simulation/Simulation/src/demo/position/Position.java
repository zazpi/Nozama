package demo.position;

public class Position {
	int id;
	public enum State {
		FREE, OCCUPIED, PREPARING, READY;
	}
	State state;
	
	public Position (int id) {
		this.id = id;
		this.state = State.FREE;
	}

	public int getId() {
		return id;
	}

	public State getState() {
		return state;
	}

	public void changeState() {
		if ((state == State.FREE) || (state == State.READY)) state = State.OCCUPIED;
		else state = State.FREE;
	}	
}
