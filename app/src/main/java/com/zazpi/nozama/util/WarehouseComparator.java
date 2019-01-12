package com.zazpi.nozama.util;

import java.util.Comparator;

import com.zazpi.nozama.model.Coordinates;
import com.zazpi.nozama.model.Warehouse;

public class WarehouseComparator {

	public static Comparator<Warehouse> getDistanceComparator(int productModelId, int destination){
		return new DistanceComparator(productModelId,destination);
	}
	
	public static class DistanceComparator implements Comparator<Warehouse>{
		int productModelId,destination;
		
		public DistanceComparator(int productModelId, int destination) {
			this.productModelId = productModelId;
			this.destination = destination;
		}

		@Override
		public int compare(Warehouse wh1, Warehouse wh2) {
			Coordinates cd = Util.getCoordinates(destination);
			Coordinates cw1 = Util.getCoordinates(wh1.getLocation());
			Coordinates cw2 = Util.getCoordinates(wh2.getLocation());
			double dw1 = Util.getDistance(cw1, cd);
			double dw2 = Util.getDistance(cw2, cd);
			return (dw1 < dw2)?-1:1;
		}
	}
	
	
}
