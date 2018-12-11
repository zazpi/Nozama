package demo;

import java.util.List;

public class Eskaera {
	int id;
	List<Produktua> produktuak;
	Workstation workstation;
	
	public Eskaera (int id, List<Produktua> produktuak, Workstation workstation) {
		this.id = id;
		this.produktuak = produktuak;
		this.workstation = workstation;
	}
}
