package com.cs557.device;

import java.util.ArrayList;
import java.util.Observer;

import com.cs557.superClasses.Azimuth;
import com.cs557.superClasses.Location;

/**
 * A class gathering the surveillance device information. This class will be
 * responsible of computing its own orientation and position.
 * 
 * @author Isabelle Santos
 *
 */
public class SurveillanceDevice {

	/* The list of the observing classes */
	private ArrayList<Observer> observers;

	/* The horizontal angle of the device's camera */
	private float horizontalViewAngle;

	/* The vertical view angle of the device's camera */
	private float verticalViewAngle;

	/* Equatorial Earth radius expressed in meters. */
	public static final double EARTH_RADIUS = 6378137;

	/** Will serve to identify the nature of any notified change */
	public static final Object POSITION_CHANGED = new Object();

	/** Will serve to identify the nature of any notified change */
	public static final Object ORIENTATION_CHANGED = new Object();

	/** Will serve to identify the nature of any notified change */
	public static final Object NO_PROVIDER = new Object();

	private LocationDevice position;
	private OrientationDevice orientation;

	/* ****************
	 * CONSTRUCTORS 
	 * ****************
	 */
	
	// TODO
	
	/* ****************
	 * METHODS 
	 * ****************
	 */
	
	/**
	 * Set the horizontal view angle of the camera
	 * 
	 * @param angle
	 */
	public void setHorizontalViewAngle(float angle) {
		horizontalViewAngle = angle;
	}
	
	/**
	 * 
	 * @return current position field
	 */
	public Location getPosition() {
		return ((Location) position).clone();
	}


	// TODO
	
}