package day15.exam;

public class LocationVO implements Comparable<LocationVO>{
	
	private String name;
	public String getName() {
		return name;
	}

	private double latitude;
	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	private double longitude;
	static LocationVO target;
	
	LocationVO(String name, double latitude, double longitude) {
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public double getCal(double latitude, double longitude) {
		double val = Math.sqrt(Math.pow(latitude - longitude, 2));
		double tar = Math.sqrt(Math.pow(target.latitude - target.longitude, 2));
		
		return Math.abs((int)(val - tar));		
	}
	
	@Override
	public int compareTo(LocationVO o) {
		
		return getCal(this.latitude, this.longitude) 
		<= getCal(o.latitude, o.longitude)
		? -1 
		: 1;
		
		
	}

}
