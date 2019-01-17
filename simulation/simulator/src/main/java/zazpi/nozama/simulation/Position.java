package zazpi.nozama.simulation;

/**
 * The car will move through different positions to reach its destination
 **/
public class Position {
	/**
	 * @param row: it indicates in which row it is
	 * @param num: it indicates in which column it is
	 * @param available: it indicates if the position is available or not
	 **/
	String row;
	int num;
	boolean available;
	
	public Position(String row,int num, boolean available) {
		this.num = num;
		this.row = row;
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
	 * If a car uses this position, other cars can't use it until the car leaves it
	 **/
	public synchronized void take() {
		try {
			while(!available) {
				System.out.println("Car waiting path " +
						row+num + " to be emptied");
				wait();
			}
			available = false;
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
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
				", available=" + available +
				'}';
	}
}
