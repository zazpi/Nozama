package demo;

import java.util.Arrays;
import java.util.List;

public class Segment {
	int id;
	List<Segment> nextSegments;
	boolean ocuped;
	
	public Segment (int id) {
		this.id = id;
		ocuped = false;
	}
	
	public void setNextSegments (Segment ... segments) {
		this.nextSegments = Arrays.asList(segments);
	}
	
	public Segment calculateNextSegment (Segment destination) {
		Segment nextSegment = null;
		
		if (nextSegments.size() == 1) nextSegment = nextSegments.get(0);
		else {
			int saltoTxiki = 6;
			for (Segment s : nextSegments) {
				int salto = 0;
				Segment segment = s;
				do {
					salto++;
					segment = segment.calculateNextSegment(destination);
				} while (segment != destination && salto < saltoTxiki);
				if (salto <= saltoTxiki) {
					nextSegment = s;
					saltoTxiki = salto;
				}
			}
		}		
		return nextSegment;
	}
	
	public synchronized boolean enterNoBlock () {
		
		return ocuped;
	}
	
	public synchronized void enter () throws InterruptedException {
		while (ocuped) wait();
		ocuped = true;
	}
	
	public synchronized void exit () {
		ocuped = false;
		notify();
		
	}

	@Override
	public String toString() {
		return "Segment: " + id;
	}
	
	
}
