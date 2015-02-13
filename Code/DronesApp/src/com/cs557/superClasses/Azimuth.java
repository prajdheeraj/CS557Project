package com.cs557.superClasses;

/**
 * Full angular orientation of the device including azimuth
 * 
 * @author Isabelle Santos
 *
 */
public class Azimuth extends Orientation implements Cloneable {

	private double azimuth;

	/* ****************
	 * CONSTRUCTORS 
	 * ****************
	 */

	public Azimuth(double pitch, double roll, double azimuth) {
		super(pitch, roll);
		this.azimuth = azimuth;
	}

	/* ****************
	 * METHODS 
	 * ****************
	 */
	
	/**
	 * 
	 * @param azimuth
	 */
	public void setAzimuth(double azimuth) {
		this.azimuth = azimuth;
	}

	/**
	 * 
	 * @return azimuth
	 */
	public double getAzimuth() {
		return azimuth;
	}

	/**
	 * Create a new Azimuth with same values
	 * 
	 * @return cloned Azimuth
	 */
	@Override
	public Azimuth clone() {
		Azimuth cloned = (Azimuth)super.clone();
		cloned.setAzimuth(azimuth);
		return cloned;
	}

}