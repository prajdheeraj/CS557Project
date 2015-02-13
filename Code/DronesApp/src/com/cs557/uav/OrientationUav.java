package com.cs557.uav;

import com.cs557.superClasses.Orientation;

/**
 * Extends Orientation for the UAV and adds the heading
 * 
 * @author Isabelle Santos
 *
 */
public class OrientationUav extends Orientation implements Cloneable {

	private double heading;

	/* ****************
	 * CONSTRUCTORS 
	 * ****************
	 */
	
	/**
	 * Create an OrientationUav instance with default values 0
	 */
	public OrientationUav() {
		super();
		this.heading = 0;
	}

	/**
	 * Create and OrientationUav instance with specified values
	 * @param pitch
	 * @param roll
	 * @param heading
	 */
	public OrientationUav(double pitch, double roll, double heading) {
		super(pitch, roll);
		this.heading = heading;
	}

	/* ****************
	 * METHODS 
	 * ****************
	 */

	/**
	 * 
	 * @return heading
	 */
	public double getHeading() {
		return heading;
	}

	/**
	 * 
	 * @param heading
	 */
	private void setHeading(double heading) {
		this.heading = heading;
	}

	/**
	 * Create a new OrientationUav with the same values.
	 * 
	 * @return cloned OrientationUAV
	 */
	public OrientationUav clone() {
		OrientationUav cloned = (OrientationUav) super.clone();
		cloned.setHeading(heading);
		return cloned;
	}

}