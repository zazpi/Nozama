package com.zazpi.nozama.util;

import java.util.List;
import java.util.Set;

import org.geonames.PostalCode;
import org.geonames.WebService;
import org.geonames.utils.Distance;

import com.zazpi.nozama.model.Coordinates;
import com.zazpi.nozama.model.ProductStack;

public class Util {
	public final static String[] CODES = {"vi","ab","a","al","av","ba","pm","b","bu","cc","ca",
			"cs","cr","co","c","cu","ge","gr","gu","ss","h","hu","j","le","l","lo","lu",
			"m","ma","mu","na","or","o","p","gc","po","sa","tf","s","sg","se","so","t",
			"te","to","v","va","bi","za","z","ce","ml"};	
	
	public static PostalCode getFirstPostalCode(int cp) {
		WebService.setUserName("bingengalartza");
		List<PostalCode> list = null;
		try {
			String cpAsString = String.format ("%05d", cp);
			list = WebService.postalCodeSearch(cpAsString, "", "ES");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(cp);
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
	
	public static List<Object[]> prepareCodes(List<Object[]> list){
		for(Object[] o : list) {
			int cp = (int) o[0];
			String code = "es-" + Util.CODES[cp - 1];
			o[0] = code;
		}
		return list;
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