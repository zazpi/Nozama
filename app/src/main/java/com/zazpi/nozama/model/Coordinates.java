package com.zazpi.nozama.model;

public class Coordinates {
	double lat;
	double lng;
	
	public Coordinates(double lat, double lng) {
		this.lat = lat;
		this.lng = lng;
	}

	public Coordinates() {}
	
	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}
	
	@Override
	public String toString() {
		return "Coordinates [lat=" + lat + ", lng=" + lng + "]";
	}
	
}
