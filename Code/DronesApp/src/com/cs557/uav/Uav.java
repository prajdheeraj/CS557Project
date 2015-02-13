package com.cs557.uav;

import com.cs557.superClasses.Location;

/**
 * This class creates an UAV with all needed informations. The
 * Information field is a formatted version of other fields to be sent
 * to the display. The fields id, name and color are not changeable
 * 
 * @author Isabelle Santos
 *
 */
public class Uav implements Cloneable {

	private volatile String id;
	protected volatile String name;
	protected volatile String color;
	private volatile double battery;
	private volatile LocationUav location;
	private volatile OrientationUav orientation;
	private volatile ClimbSpeed climbSpeed;
	private volatile GroundSpeed groundSpeed;
	private volatile TrueAirSpeed trueAirSpeed;
	private volatile double throttle;
	private volatile Target target;

	private volatile Information infos;

	/* ****************
	 * CONSTRUCTORS 
	 * ****************
	 */
	
	/**
	 * Create Uav instance with specified id
	 * 
	 * @param id
	 */
	public Uav(String id) {
		this.id = id;
		name = "nom";
		color = "#000000";
		battery = 0;
		location = new LocationUav();
		orientation = new OrientationUav();
		climbSpeed = new ClimbSpeed();
		groundSpeed = new GroundSpeed();
		trueAirSpeed = new TrueAirSpeed();
		throttle = 0;
		target = new Target(location, climbSpeed);

		// updating infos
		infos = new Information(id);
		infos.setId(id);
	}


	/* ****************
	 * METHODS 
	 * ****************
	 */

	/**
	 * 
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * set id and update infos
	 * 
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
		infos.setId(id);
	}

	/**
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * set name and update infos
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
		infos.setName(name);
	}

	/**
	 * 
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * set color and update infos
	 * 
	 * @param color
	 */
	public void setColor(String color) {
		this.color = color;
		infos.setColor(color);
	}

	/**
	 * 
	 * @return the battery
	 */
	public double getBattery() {
		return battery;
	}

	/**
	 * 
	 * @return the location
	 */
	public LocationUav getLocation() {
		return location;
	}

	/**
	 * 
	 * @return a clone of location
	 */
	public LocationUav getLocationCloned() {
		return location.clone();
	}

	/**
	 * Set the location and update infos.
	 * 
	 * @param location
	 *            the location to set
	 */
	public void setLocation(LocationUav location, Location locationDevice) {
		infos.setAltitude(location.getAltitude());
		infos.setHeight(location.getHeight());
		infos.setDistanceToPilot(location.distance(locationDevice));
		this.location = location;
	}

	/**
	 * Set the location and update infos. Used by clone method.
	 * 
	 * @param location
	 *            the location to set
	 */
	public void setLocation(LocationUav location) {
		this.location = location;
	}

	/**
	 * the battery and update infos
	 * 
	 * @param battery
	 */
	public void setBattery(double battery) {
		infos.setBattery(battery);
		this.battery = battery;
	}

	/**
	 * 
	 * @return climbSpeed
	 */
	public ClimbSpeed getClimbSpeed() {
		return climbSpeed;
	}

	/**
	 * 
	 * @return clone of climbSpeed
	 */
	public ClimbSpeed getClimbSpeedCloned() {
		return climbSpeed.clone();
	}

	/**
	 * 
	 * @param climbSpeed
	 *            and update infos
	 */
	public void setClimbSpeed(ClimbSpeed climbSpeed) {
		infos.setClimbSpeed(climbSpeed.getValue());
		this.climbSpeed = climbSpeed;
	}

	/**
	 * 
	 * @return groundSpeed
	 */
	public GroundSpeed getGroundSpeed() {
		return groundSpeed;
	}

	/**
	 * 
	 * @return a clone of groundSpeed
	 */
	public GroundSpeed getGroundSpeedCloned() {
		return groundSpeed.clone();
	}

	/**
	 * Set the groundSpeed and update infos
	 * 
	 * @param groundSpeed
	 *            new ground speed to set
	 */
	public void setGroundSpeed(GroundSpeed groundSpeed) {
		infos.setOutbound(groundSpeed.isOutbound());
		infos.setGroundSpeed(groundSpeed.getValue());
		this.groundSpeed = groundSpeed;
	}

	/**
	 * set the GroundSpeed and update infos
	 * 
	 * @param groundSpeed
	 */
	public void setGroundSpeed(GroundSpeed groundSpeed,
			Location locationDevice) {
		infos.setGroundSpeed(groundSpeed.getValue());
		this.groundSpeed = groundSpeed;
		this.groundSpeed.setGroundSpeed(locationDevice.distance(this.location));
	}

	/**
	 * 
	 * @return trueAirSpeed
	 */
	public TrueAirSpeed getTrueAirSpeed() {
		return trueAirSpeed;
	}

	/**
	 * 
	 * @return a clone of trueAirSpeed
	 */
	public TrueAirSpeed getTrueAirSpeedCloned() {
		return trueAirSpeed.clone();
	}

	/**
	 * set TrueAirSpeed and update infos
	 * 
	 * @param trueAirSpeed
	 */
	private void setTrueAirSpeed(TrueAirSpeed trueAirSpeed) {
		infos.setAirSpeed(trueAirSpeed.getValue());
		this.trueAirSpeed = trueAirSpeed;
	}

	/**
	 * 
	 * @return OrientationUAV
	 */
	public OrientationUav getOrientation() {
		return orientation;
	}

	/**
	 * 
	 * @return a clone of UAV orientation
	 */
	public OrientationUav getOrientationCloned() {
		return orientation.clone();
	}

	/**
	 * set Orientation and update infos
	 * 
	 * @param orientation
	 */
	public void setOrientation(OrientationUav orientation) {
		infos.setRoll(orientation.getRoll());
		infos.setPitch(orientation.getPitch());
		infos.setHeading(orientation.getHeading());
		this.orientation = orientation;
	}

	/**
	 * 
	 * @return the throttle
	 */
	public double getThrottle() {
		return throttle;
	}

	/**
	 * Set the throttle and update infos
	 * 
	 * @param throttle
	 */
	public void setThrottle(double throttle) {
		infos.setThrottle(throttle);
		this.throttle = throttle;
	}

	/**
	 * 
	 * @return the target
	 */
	public Target getTarget() {
		return target;
	}

	/**
	 * @return a clone of target
	 */
	public Target getTargetCloned() {
		return target.clone();
	}

	/**
	 * 
	 * @param target
	 * @param location
	 */
	public void setTarget(Target target, LocationUav location) {
		this.infos.setClimbTarget(target.getTargetClimbSpeed().getValue());
		this.infos.setDistanceToTarget(target.getTargetLocation().distance(
				location));
		this.target = target;
		this.location = location;
	}

	/**
	 * 
	 * @return the infos
	 */
	public Information getInfos() {
		return infos.clone();
	}

	/**
	 * 
	 * @param infos
	 */
	private void setInfos(Information infos) {
		this.infos = infos;
	}

	/**
	 * Update the battery and the throttle.
	 * 
	 * @param clone
	 */
	public void updateEngine(Uav clone) {
		this.setBattery(clone.getBattery());
		this.setThrottle(clone.getThrottle());
	}
	
	/**
	 * Updating function used by fleet when new parameters data are received.
	 * 
	 * @param clone
	 *            the CloneUAV changed by the parser
	 */
	public void updateParameters(Uav clone, Location locationDevice) {

		// Copy all needed information of the clone
		this.setLocation(clone.getLocationCloned(), locationDevice);
		this.setOrientation(clone.getOrientationCloned());
		this.setClimbSpeed(clone.getClimbSpeedCloned());
		this.setTrueAirSpeed(clone.getTrueAirSpeedCloned());
		this.setGroundSpeed(clone.getGroundSpeedCloned(), locationDevice);
		this.setTarget(this.target, clone.getLocationCloned());
	}
	
	/**
	 * Update the Target of this UAV.
	 * 
	 * @param clone
	 */
	public void updateTarget(Uav clone) {
		this.setTarget(clone.getTarget(), location);
	}

	/**
	 * Update the name and the color of this UAV
	 * 
	 * @param clone
	 */
	public void updateConfig(Uav clone) {
		this.setName(clone.getName());
		this.setColor(clone.getColor());
	}

	/**
	 * Create a new Uav with same values
	 * 
	 * @return cloned Uav
	 */
	public Uav clone() {
		try {
			Uav cloned = (Uav) super.clone();

			cloned.setId(id);
			cloned.setName(name);
			cloned.setColor(color);
			cloned.setBattery(battery);
			cloned.setLocation(location.clone());
			cloned.setOrientation(orientation);
			cloned.setClimbSpeed(climbSpeed);
			cloned.setGroundSpeed(groundSpeed);
			cloned.setTrueAirSpeed(trueAirSpeed);
			cloned.setThrottle(throttle);
			cloned.setTarget(target, location);
			cloned.setInfos(infos);

			return cloned;
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
	}
}