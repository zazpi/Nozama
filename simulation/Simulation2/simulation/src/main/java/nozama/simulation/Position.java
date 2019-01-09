package nozama.simulation;

public class Position {
	String row;
	int num;
	boolean available;
	
	public Position(String row,int num, boolean available) {
		this.num = num;
		this.row = row;
		this.available = available;
	}
	
	public int getNum() {
		return num;
	}
	
	public String getRow() {
		return row;
	}

	public synchronized void take() {
		try {
			while(!available) wait();
			available = false;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized boolean available() {
		
		return available;
	}
	
	public synchronized void free() {
		available = true;
		notify();
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
		} else if (!row.equals(other.row))
			return false;
		return true;
	}




	
	


}
