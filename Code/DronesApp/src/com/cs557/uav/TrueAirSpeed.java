package com.cs557.uav;

import com.cs557.superClasses.Speed;

/** 
 * TAS of the drone
 * 
 * @author Isabelle Santos
 * @see Speed
 *
 */
public class TrueAirSpeed extends Speed implements Cloneable {

	/* ****************
	 * CONSTRUCTORS 
	 * ****************
	 */

	/**
	 * Create TrueAirSpeed instance with default value 0
	 */
	public TrueAirSpeed() {
		super();
	}

	/**
	 * Create a ClimbSpeed instance with specified value.
	 * 
	 * @param speed
	 */
	public TrueAirSpeed(double value) {
		super(value);
	}


	/* ****************
	 * METHODS 
	 * ****************
	 */

	/**
	 * Create a new GroundSpeed with same values
	 * 
	 * @return cloned TrueAirSpeed
	 */
	public TrueAirSpeed clone() {
		TrueAirSpeed cloned = (TrueAirSpeed) super.clone();
		cloned.setValue(super.getValue());
		return cloned;
	}

}