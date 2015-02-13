package com.cs557.superClasses;

/**
 * Superclass to locate things
 * 
 * @author Isabelle Santos
 *
 */
public class Location implements Cloneable {

	protected double latitude;
	protected double longitude;
	protected double altitude;

	/* ****************
	 * CONSTRUCTORS 
	 * ****************
	 */

	/**
	 * Create a Location instance with default latitude, longitude and
	 * altitude above sea level at 0.
	 */
	public Location() {
		this(0, 0, 0);
	}

	/**
	 * Create a Location instance with specified latitude, longitude and
	 * altitude above sea level.
	 * 
	 * @param latitude
	 * @param longitude
	 * @param altitude
	 */
	public Location(double latitude, double longitude, double altitude) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.altitude = altitude;
	}
	
	/* ****************
	 * METHODS 
	 * ****************
	 */

	/**
	 * @return latitude
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return longitude
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return altitude
	 */
	public double getAltitude() {
		return altitude;
	}

	/**
	 * @param altitude
	 */
	public void setAltitude(double altitude) {
		this.altitude = altitude;
	}
	
	/**
	 * Compute the distance between this location and the other location
	 * using the law of haversines
	 * 
	 * @param other
	 * @return distance
	 */
	public double distance(Location other) {

		double R = 6371; // Earth radius
		// Convert latitudes to radians
		double latRadThis = this.latitude * (Math.PI) / 180;
		double latRadOther = other.latitude * (Math.PI) / 180;
		double deltaLat = (this.latitude - other.latitude) * (Math.PI) / 180;
		double deltaLong = (this.longitude - other.longitude) * (Math.PI) / 180;

		// Intermediate computations
		double a = Math.sin(deltaLat / 2) * Math.sin(deltaLat / 2)
				+ Math.cos(latRadThis) * Math.cos(latRadOther)
				* Math.sin(deltaLong / 2) * Math.sin(deltaLong / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

		double distance = R * c;
		return distance;
	}

	/**
	 * Create a new Location with the same value.
	 * 
	 * @return Location
	 */
	public Location clone() {
		try {
			Location cloned = (Location) super.clone();
			cloned.setLatitude(latitude);
			cloned.setLongitude(longitude);
			cloned.setAltitude(altitude);
			return cloned;
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
	}
	
}