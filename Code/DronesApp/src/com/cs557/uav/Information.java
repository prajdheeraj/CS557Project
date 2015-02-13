package com.cs557.uav;

/**
 * Information regarding the UAV sent to the display
 * 
 * @author Isabelle Santos
 *
 */
public class Information implements Cloneable {

	private String name;
	private String id;
	private String color;
	private double height;
	private double altitude;
	private double battery;
	private double airSpeed;
	private boolean isOutbound;
	private double roll;
	private double pitch;
	private double heading;
	private double groundSpeed;
	private double climbSpeed;
	private double throttle;
	private double climbTarget;
	private double distanceToTarget;
	private double distanceToPilot;



	/* ****************
	 * CONSTRUCTORS 
	 * ****************
	 */
	
	/**
	 * Create information instance with the specified id
	 * 
	 * @param id
	 */
	public Information(String id) {
		name = "name";
		this.id = id;
		color = "#000000";
		height = 0;
		altitude = 0;
		battery = 0;
		airSpeed = 0;
		roll = 0;
		pitch = 0;
		heading = 0;
		groundSpeed = 0;
		climbSpeed = 0;
		throttle = 0;
		climbTarget = 0;
		distanceToTarget = 0;
		distanceToPilot = 0;
	}

	/* ****************
	 * METHODS 
	 * ****************
	 */

	/**
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	protected void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 */
	protected void setId(String id) {
		this.id = id;
	}

	/**
	 * 
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * 
	 * @param color
	 */
	protected void setColor(String color) {
		this.color = color;
	}

	/**
	 * 
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * 
	 * @param agl
	 * 			above ground level
	 */
	protected void setHeight(double agl) {
		this.height = agl;
	}
	

	/**
	 * 
	 * @return the altitude
	 */
	public double getAltitude() {
		return height;
	}

	/**
	 * 
	 * @param amsl
	 * 			above sea level
	 */
	protected void setAltitude(double amsl) {
		this.height = amsl;
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
	 * @param battery
	 */
	protected void setBattery(double battery) {
		this.battery = battery;
	}

	/**
	 * 
	 * @return the airSpeed
	 */
	public double getAirSpeed() {
		return airSpeed;
	}

	/**
	 * 
	 * @param airSpeed
	 */
	protected void setAirSpeed(double airSpeed) {
		this.airSpeed = airSpeed;
	}

	/**
	 * 
	 * @return isOutbound
	 */
	public boolean isOutbound() {
		return isOutbound;
	}

	/**
	 * 
	 * @param isOutbound
	 */
	protected void setOutbound(boolean isOutbound) {
		this.isOutbound = isOutbound;
	}

	/**
	 * 
	 * @return distanceToPilot
	 */
	public double getDistanceToPilot() {
		return distanceToPilot;
	}

	/**
	 * 
	 * @param distanceToPilot
	 */
	protected void setDistanceToPilot(double distanceToPilot) {
		this.distanceToPilot = distanceToPilot;
	}

	/**
	 * 
	 * @return the roll
	 */
	public double getRoll() {
		return roll;
	}

	/**
	 * 
	 * @param roll
	 */
	protected void setRoll(double roll) {
		this.roll = roll;
	}

	/**
	 * @return the pitch
	 */
	public double getPitch() {
		return pitch;
	}

	/**
	 * 
	 * @param pitch
	 */
	protected void setPitch(double pitch) {
		this.pitch = pitch;
	}

	/**
	 * 
	 * @return the heading
	 */
	public double getHeading() {
		return heading;
	}

	/**
	 * 
	 * @param heading
	 */
	protected void setHeading(double heading) {
		this.heading = heading;
	}

	/**
	 * 
	 * @return the groundSpeed
	 */
	public double getGroundSpeed() {
		return groundSpeed;
	}

	/**
	 * 
	 * @param groundSpeed
	 */
	protected void setGroundSpeed(double groundSpeed) {
		this.groundSpeed = groundSpeed;
	}

	/**
	 * 
	 * @return the climbSpeed
	 */
	public double getClimbSpeed() {
		return climbSpeed;
	}

	/**
	 * 
	 * @param climbSpeed
	 */
	protected void setClimbSpeed(double climbSpeed) {
		this.climbSpeed = climbSpeed;
	}

	/**
	 * 
	 * @return the throttle
	 */
	public double getThrottle() {
		return throttle;
	}

	/**
	 * 
	 * @param throttle
	 */
	protected void setThrottle(double throttle) {
		this.throttle = throttle;
	}

	/**
	 * 
	 * @return the climbTarget
	 */
	public double getClimbTarget() {
		return climbTarget;
	}

	/**
	 * 
	 * @param climbTarget
	 */
	protected void setClimbTarget(double climbTarget) {
		this.climbTarget = climbTarget;
	}

	/**
	 * 
	 * @return the distanceToTarget
	 */
	public double getDistanceToTarget() {
		return distanceToTarget;
	}

	/**
	 * 
	 * @param distanceToTarget
	 */
	public void setDistanceToTarget(double distanceToTarget) {
		this.distanceToTarget = distanceToTarget;
	}

	/**
	 * Create new Information with same values
	 * 
	 * @return cloned Information
	 */
	public Information clone() {
		try {
			Information cloned = (Information) super.clone();
			cloned.setName(name);
			cloned.setColor(color);
			cloned.setHeight(height);
			cloned.setBattery(battery);
			cloned.setAirSpeed(airSpeed);
			cloned.setRoll(roll);
			cloned.setPitch(pitch);
			cloned.setHeading(heading);
			cloned.setGroundSpeed(groundSpeed);
			cloned.setClimbSpeed(climbSpeed);
			cloned.setAltitude(altitude);
			cloned.setThrottle(throttle);
			cloned.setClimbTarget(climbTarget);
			cloned.setDistanceToTarget(distanceToTarget);
			return cloned;
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
	}

}