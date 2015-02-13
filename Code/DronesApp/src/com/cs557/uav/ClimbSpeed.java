package com.cs557.uav;

import com.cs557.superClasses.Speed;

/** 
 * Vertical speed of the drone
 * 
 * @author Isabelle Santos
 * @see Speed
 *
 */
public class ClimbSpeed extends Speed implements Cloneable {

	/* ****************
	 * CONSTRUCTORS 
	 * ****************
	 */
	
	/**
	 * Create a ClimbSpeed instance with default value at 0.
	 */
	public ClimbSpeed() {
		super();
	}
	
	/**
	 * Create a ClimbSpeed instance with specified value.
	 * 
	 * @param speed
	 */
	public ClimbSpeed(double value) {
		super(value);
	}
	
	/* ****************
	 * METHODS 
	 * ****************
	 */

	/**
	 * Create a new ClimbSpeed with the same value.
	 * 
	 * @return cloned ClimbSpeed
	 */
	public ClimbSpeed clone() {
		ClimbSpeed cloned = (ClimbSpeed) super.clone();
		cloned.setValue(super.getValue());
		return cloned;
	}
	
}