package com.zazpi.nozama.util;

import java.util.List;
import java.util.Set;

import org.geonames.PostalCode;
import org.geonames.WebService;
import org.geonames.utils.Distance;

import com.zazpi.nozama.model.Coordinates;
import com.zazpi.nozama.model.ProductStack;

public class Util {
	
	public static PostalCode getFirstPostalCode(int cp) {
		WebService.setUserName("bingengalartza");
		List<PostalCode> list = null;
		try {
			list = WebService.postalCodeSearch(String.valueOf(cp), "", "ES");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list.get(0);		  
	}
	
	public static Coordinates getCoordinates(int cp) {
		Coordinates coords = new Coordinates();
		PostalCode first = getFirstPostalCode(cp);
		if(first != null) {
		    coords.setLat(first.getLatitude());
			coords.setLng(first.getLongitude());
		  }
		return coords;
	}
	
	public static String getAdminCode(int cp) {
		PostalCode first = getFirstPostalCode(cp);
		String code = "undefined";
		if(first != null) {
			code = first.getCountryCode() + "-" + first.getAdminCode2();
			code = code.toLowerCase();
		}
			
		return code;	
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