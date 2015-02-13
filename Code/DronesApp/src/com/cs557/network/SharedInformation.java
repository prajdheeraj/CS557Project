package com.cs557.network;

import com.cs557.device.SurveillanceDevice;
import com.cs557.fleet.Fleet;
import com.cs557.preferences.Settings;

/**
 * Gathers information from different classes for the Parser
 * 
 * @author Isabelle Santos
 *
 */
public class SharedInformation {

	private static SurveillanceDevice device;
	private static Fleet fleet;
	private static Settings settings;

	/* ****************
	 * CONSTRUCTORS 
	 * ****************
	 */
	
	private SharedInformation() {
	}
	
	/**
	 * Initialize static fields
	 * 
	 * @param myDevice
	 */
	public static void init(SurveillanceDevice myDevice) {
		device = myDevice;
		fleet = new Fleet(device);
		settings = new Settings();
	}
	
	/* ****************
	 * METHODS 
	 * ****************
	 */

	/**
	 * 
	 * @return the settings
	 */
	public static Settings getSettings() {
		return settings;
	}

	/**
	 * 
	 * @return the fleet
	 */
	public static Fleet getFleet() {
		return fleet;
	}

	/**
	 * 
	 * @return the device
	 */
	public static SurveillanceDevice getDevice() {
		return device;
	}

}