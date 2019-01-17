package zazpi.nozama.simulation;

/**
 * Parking is one of the different position types
 * It uses Position class' methods apart from a couple of new ones
 **/
public class Parking extends Position {
	/**
	 * @param path: this is the path that is connected to the parking
	 * @param car: if the parking is occupied, it will have the information of which car it is
	 **/
	Position path;
	Car car;	
	
	public Parking(String row, int num, boolean available, Position path) {
		super(row, num, available);
		this.path = path;
	}
	
	/**
	 * Get the position to which is connected
	 * @return position
	 **/
	public Position getPath() {
		return path;
	}
	
	/**
	 * It sets the car in the current parking and it puts as unavailable
	 * @param car
	 **/
	public void setCar(Car car) {
		this.car = car;
		available = false;
	}
	
	/**
	 * The car leaves the parking, putting it available and without the car. The method
	 * also sets the car's position to the one that is connected to the parking and
	 * changes the positions availability to occupied
	 **/
	public void leave () {
		System.out.println("Car " + car.getId() + " living parking " + row+num);
		path.take();
		car.setCurrentPos(path);
		car = null;
		available = true;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((path == null) ? 0 : path.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parking other = (Parking) obj;
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		return true;
	}	
}
