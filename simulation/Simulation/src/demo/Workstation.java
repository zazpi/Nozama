package demo;

public class Workstation {
	int id;
	Langilea langilea;
	Segment segment;
	
	public Workstation (int id) {
		this.id = id;
		langilea = new Langilea();
	}

	public void setSegment(Segment segment) {
		this.segment = segment;
	}

	public Segment getSegment() {
		return segment;
	}
}
