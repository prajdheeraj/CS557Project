package com.cs557.uav;

import com.cs557.superClasses.Location;

/**
 * Target ClimbSpeed and Location of the UAV
 * 
 * @author Isabelle Santos
 *
 */
public class Target implements Cloneable {

	private Location targetLocation;
	private ClimbSpeed targetClimbSpeed;

	/* ****************
	 * CONSTRUCTORS 
	 * ****************
	 */

	/**
	 * Create an Target instance with the specified Location and ClimbSpeed.
	 * 
	 * @param targetLocation
	 * @param targetClimbSpeed
	 */
	public Target(Location targetLocation, ClimbSpeed targetClimbSpeed) {
		this.targetClimbSpeed = targetClimbSpeed.clone();
		this.targetLocation = targetLocation.clone();
	}

	/* ****************
	 * METHODS 
	 * ****************
	 */

	/**
	 * 
	 * @return the targetLocation
	 */
	public Location getTargetLocation() {
		return targetLocation.clone();
	}

	/**
	 * 
	 * @param targetLocation
	 */
	private void setTargetLocation(Location targetLocation) {
		this.targetLocation = targetLocation.clone();
	}

	/**
	 * 
	 * @return the targetClimb
	 */
	public ClimbSpeed getTargetClimbSpeed() {
		return targetClimbSpeed.clone();
	}

	/**
	 * 
	 * @param targetClimb
	 */
	private void setTargetClimbSpeed(ClimbSpeed targetClimbSpeed) {
		this.targetClimbSpeed = targetClimbSpeed.clone();
	}

	/**
	 * Create new Target with the same location and climb targeted.
	 * 
	 * @return cloned Target
	 */
	public Target clone() {
		try {
			Target cloned = (Target) super.clone();
			cloned.setTargetClimbSpeed(targetClimbSpeed);
			cloned.setTargetLocation(targetLocation);
			return cloned;
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
	}

}