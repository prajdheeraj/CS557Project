package com.cs557.uav;

import com.cs557.superClasses.Speed;

/**
 * Speed of the drone relative to the ground
 * 
 * @author Isabelle Santos
 * @see Speed
 *
 */
public class GroundSpeed extends Speed implements Cloneable {
	
	private boolean isOutbound; // is UAV moving away from the pilot
	private double previousDistance;

	/* ****************
	 * CONSTRUCTORS 
	 * ****************
	 */

	/**
	 * Create GroundSpeed instance with default Speed values and
	 * drone initially not moving at distance 0
	 */
	public GroundSpeed() {
		super();
		isOutbound = false;
		previousDistance = 0;
	}
	
	/**
	 * Create GroundSpeed instance with drone at given distance
	 * 
	 * @param distance
	 *            the current distance from the pilot
	 */
	public GroundSpeed(double distance) {
		super();
		isOutbound = false;
		previousDistance = distance;
	}

	/* ****************
	 * METHODS 
	 * ****************
	 */

	/**
	 * Return true if UAV is going away from the pilot
	 * false otherwise
	 * 
	 * @return isUavOutbound
	 */
	public boolean isOutbound() {
		return this.isOutbound;
	}
	
	/**
	 * Set distance from pilot
	 * 
	 * @param previousDistance
	 */
	private void setPreviousDistance(double previousDistance) {
		this.previousDistance = previousDistance;
	}

	/**
	 * Set direction of movement relative to the pilot
	 * 
	 * @param distance
	 *            the distance between the UAV and the GCS
	 */
	public void setGroundSpeed(double distance) {
		isOutbound = distance > previousDistance;
		previousDistance = distance;
	}

	/**
	 * Create a new GroundSpeed with same values
	 * 
	 * @return cloned GroundSpeed
	 */
	public GroundSpeed clone() {
		GroundSpeed cloned = (GroundSpeed) super.clone();
		cloned.setValue(super.getValue());
		cloned.setPreviousDistance(previousDistance);
		return cloned;
	}

}