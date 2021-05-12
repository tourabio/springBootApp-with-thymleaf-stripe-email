package tn.esprit.spring.entities;

public class CoordonneeCity {
	private double longitude ;
	private double latitude ;	
	

	public CoordonneeCity() {
		// TODO Auto-generated constructor stub
	}


	public CoordonneeCity(double longitude, double latitude) {
		super();
		this.longitude = longitude;
		this.latitude = latitude;
	}


	public double getLongitude() {
		return longitude;
	}


	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}


	public double getLatitude() {
		return latitude;
	}


	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}


	@Override
	public String toString() {
		return "CoordonneeCity [longitude=" + longitude + ", latitude=" + latitude + "]";
	}
	
	
	
	
}
