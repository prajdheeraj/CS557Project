package com.cs557.uav;

import com.cs557.superClasses.Location;

/**
 * Extends Location for the UAV and adds height (distance from ground)
 * 
 * @author Isabelle Santos
 *
 */
public class LocationUav extends Location implements Cloneable {

	private double height;


	/* ****************
	 * CONSTRUCTORS 
	 * ****************
	 */

	/**
	 * Create a LocationUav instance with default value at 0.
	 */
	public LocationUav() {
		super();
		this.height = 0;
	}
	
	/**
	 * Create a LocationUav instance with specified values
	 * 
	 * @param latitude
	 * @param longitude
	 * @param amsl
	 * 			above mean sea level
	 * @param agl
	 * 			above ground level
	 */
	public LocationUav(double latitude, double longitude, double amsl, double agl) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.altitude = amsl;
		this.height = agl;
	}

	/* ****************
	 * METHODS 
	 * ****************
	 */

	/**
	 * 
	 * @return the altitudeAboveGround
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * 
	 * @param altitudeAboveGround
	 */
	protected void setHeight(double altitudeAboveGround) {
		this.height = altitudeAboveGround;
	}
	
	/**
	 * Create a new LocationUav with the same values
	 * 
	 * @return cloned LocationUAV
	 */
	public LocationUav clone() {
		LocationUav cloned = (LocationUav) super.clone();
		cloned.setHeight(height);
		return cloned;
	}

}