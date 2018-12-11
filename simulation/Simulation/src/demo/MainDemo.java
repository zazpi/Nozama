package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainDemo {
	public static final int N_WORKSTATIONS = 6;
	public static final int N_PRODUCTS = 30;
	public static final int N_ORDERS = 15;
	public static final int N_SEGMENTS = 16;
	
	List<Workstation> workstations;
	List<Produktua> produktuak;
	List<Eskaera> eskaerak;
	List<Segment> segments;
	
	ThreadCar [] threadCar;
	Thread [] threads;
	
	public MainDemo () {
		workstations = new ArrayList<>();
		produktuak = new ArrayList<>();
		eskaerak = new ArrayList<>();
		segments = new ArrayList<>();
		Random random = new Random();
		
		for (int j=0;j<N_PRODUCTS;j++) {
			produktuak.add(new Produktua(j, workstations.get(random.nextInt(N_WORKSTATIONS))));
		}
		
		for (int k=0;k<N_ORDERS;k++) {
			List<Produktua> orderProducts = new ArrayList<>();
			for (int l=0;l<random.nextInt(4);l++) {
				orderProducts.add(produktuak.get(random.nextInt(N_PRODUCTS)));
			}
			eskaerak.add(new Eskaera(k, orderProducts, workstations.get(random.nextInt(N_WORKSTATIONS))));
		}
		
		for (int l=0;l<N_SEGMENTS;l++) {
			segments.add(new Segment(l));
		}
		segments.get(0).setNextSegments(segments.get(5));
		segments.get(1).setNextSegments(segments.get(0));
		segments.get(2).setNextSegments(segments.get(1)); //7
		segments.get(3).setNextSegments(segments.get(2));
		segments.get(4).setNextSegments(segments.get(3)); //9
		
		segments.get(5).setNextSegments(segments.get(11));
		segments.get(6).setNextSegments(segments.get(0));
		segments.get(7).setNextSegments(segments.get(13));
		segments.get(8).setNextSegments(segments.get(2));
		segments.get(9).setNextSegments(segments.get(15));
		segments.get(10).setNextSegments(segments.get(4));
		
		segments.get(11).setNextSegments(segments.get(12)); //6
		segments.get(12).setNextSegments(segments.get(13));
		segments.get(13).setNextSegments(segments.get(14)); //8
		segments.get(14).setNextSegments(segments.get(15));
		segments.get(15).setNextSegments(segments.get(10));
		
		for (int i=0;i<N_WORKSTATIONS;i++) {
			workstations.add(new Workstation(i));
		}
		workstations.get(0).setSegment(segments.get(4));
		workstations.get(1).setSegment(segments.get(2));
		workstations.get(2).setSegment(segments.get(0));
		workstations.get(3).setSegment(segments.get(11));
		workstations.get(4).setSegment(segments.get(13));
		workstations.get(5).setSegment(segments.get(15));
		
		System.out.println(segments.get(13).calculateNextSegment(segments.get(2)));
		
	}
	
	public static void main (String [] args) {
		MainDemo mainDemo = new MainDemo();
	}
}
