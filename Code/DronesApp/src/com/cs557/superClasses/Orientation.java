package com.cs557.superClasses;

/**
 * Superclass for pitch and roll
 * @author Isabelle Santos
 *
 */
public class Orientation implements Cloneable {

	private double pitch;
	private double roll;

	/* ****************
	 * CONSTRUCTORS 
	 * ****************
	 */
	
	/**
	 * Create an Orientation instance with default value at (0,0)
	 */
	public Orientation() {
		this(0, 0);
	}

	/**
	 * Create an Orientation instance with specified values
	 * @param pitch
	 * @param roll
	 */
	public Orientation(double pitch, double roll) {
		this.pitch = pitch;
		this.roll = roll;
	}

	/* ****************
	 * METHODS 
	 * ****************
	 */

	/**
	 * 
	 * @return the pitch angle
	 */
	public double getPitch() {
		return pitch;
	}

	/**
	 * 
	 * @param pitch
	 */
	public void setPitch(double pitch) {
		this.pitch = pitch;
	}

	/**
	 * 
	 * @return the roll angle
	 */
	public double getRoll() {
		return roll;
	}

	/**
	 * 
	 * @param roll
	 */
	public void setRoll(double roll) {
		this.roll = roll;
	}
	
	/**
	 * Create a new Orientation with the same value.
	 * 
	 * @return Orientation
	 */
	public Orientation clone() {
		try {
			Orientation cloned = (Orientation) super.clone();
			cloned.setPitch(pitch);
			cloned.setRoll(roll);
			return cloned;
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
	}

}