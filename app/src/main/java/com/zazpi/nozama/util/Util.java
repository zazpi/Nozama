package com.zazpi.nozama.util;

import java.util.List;
import java.util.Set;

import org.geonames.PostalCode;
import org.geonames.WebService;
import org.geonames.utils.Distance;

import com.zazpi.nozama.model.Coordinates;
import com.zazpi.nozama.model.ProductStack;

public class Util {

	public static Coordinates getCoordinates(int cp) {
		WebService.setUserName("bingengalartza");
		Coordinates coords = new Coordinates();
		try {	  
			  List<PostalCode> list = WebService.postalCodeSearch(String.valueOf(cp), "", "ES");
			  PostalCode first = list.get(0);
			  if(first != null) {
				  coords.setLat(first.getLatitude());
				  coords.setLng(first.getLongitude());
			  }
		}catch (Exception e) {
			coords = null;
		}
		return coords;
	}
	
	public static double getDistance(Coordinates a, Coordinates b) {
		return Distance.distanceKM(a.getLat(), a.getLng(), b.getLat(), b.getLng());
	}
	
	public static double getDistance(int pcA, int pcB) {
		return getDistance(getCoordinates(pcA),getCoordinates(pcB));
	}
	
	public static int calculateTotalStock(Set<ProductStack> list) {
		int stock = 0;
		for(ProductStack ps : list) {
			stock += ps.getStock();
		}
		return stock;
	}
	
}