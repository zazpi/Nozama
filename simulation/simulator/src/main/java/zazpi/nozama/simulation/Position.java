package zazpi.nozama.simulation;

import java.util.logging.Logger;

/**
 * The car will move through different positions to reach its destination
 **/
public class Position {
	/**
	 * @param row: it indicates in which row it is
	 * @param num: it indicates in which column it is
	 * @param pos: the exact position inside a path
	 * @param available: it indicates if the position is available or not
	 **/
	private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	String row;
	int num;
	int pos;
	boolean available;
	
	public Position(String row,int num, boolean available) {
		this.num = num;
		this.row = row;
		pos = 0;
		this.available = available;
	}
	
	/**
	 * Get the column of the position
	 * @return num
	 */
	public int getNum() {
		return num;
	}
	
	/**
	 * Get the row of the position
	 * @return row
	 **/
	public String getRow() {
		return row;
	}
	
	/**
	 * Get the exact position in the path
	 * @return pos
	 */
	public synchronized int getPos () {
		return pos;
	}
	
	/**
	 * Set the exact position the car will have in the path
	 * @param pos
	 */
	public synchronized void setPos (int pos) {
		this.pos = pos;
	}
	
	/**
	 * It will move through the path
	 * @param num: If the car wants to move to a workstation or a parking this number will
	 * be different because it won't move through all the path
	 */
	public synchronized void moveInsideThePath (int num) {
		while (pos <= num) {
			pos++;
			Util.safeSleep(50);
		}
	}
	
	/**
	 * If a car uses this position, other cars can't use it until the car leaves it
	 **/
	public synchronized void take() {
		try {
			while(!available) {
				LOGGER.info("Car waiting path " +
						row+num + " to be emptied");
				wait();
			}
			available = false;
		} catch (InterruptedException e) {
			LOGGER.severe("Exception: " + e.getMessage());
			Thread.currentThread().interrupt();
		}
	}
	
	/**
	 * Get the availability of the position
	 * @return available
	 **/
	public synchronized boolean available() {		
		return available;
	}
	 
	/**
	 * After leaving the position, it will be available for other cars
	 **/
	public synchronized void free() {
		available = true;
		notifyAll();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + num;
		result = prime * result + ((row == null) ? 0 : row.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (num != other.num)
			return false;
		if (row == null) {
			if (other.row != null)
				return false;
		} else if (!row.equals(other.row)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Position{" +
				"row='" + row + '\'' +
				", num=" + num +
				", pos=" + pos +
				", available=" + available +
				'}';
	}
}
