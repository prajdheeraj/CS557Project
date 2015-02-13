package com.cs557.superClasses;

/** 
 * Superclass to create different kinds of speeds
 * 
 * @author Isabelle Santos
 *
 */
public abstract class Speed implements Cloneable {

	private double value;

	/* ****************
	 * CONSTRUCTORS 
	 * ****************
	 */

	/**
	 * Create a Speed instance with default value at 0.
	 */
	public Speed() {
		this.value = 0;
	}
	
	/**
	 * Create a Speed instance with specified value.
	 * 
	 * @param speed
	 */
	public Speed(double speed) {
		this.value = speed;
	}
	
	/* ****************
	 * METHODS 
	 * ****************
	 */

	/**
	 * 
	 * @return value
	 */
	public double getValue() {
		return value;
	}

	/**
	 * 
	 * @param value
	 */
	public void setValue(double value) {
		this.value = value;
	}
	
	/**
	 * Create a new Speed with the same value.
	 * 
	 * @return Speed
	 */
	public Speed clone() {
		try {
			Speed cloned = (Speed) super.clone();
			cloned.setValue(value);
			return cloned;
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
	}

}