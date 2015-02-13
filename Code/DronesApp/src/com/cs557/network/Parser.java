package com.cs557.network;

import java.util.Observable;

import com.cs557.fleet.Fleet;

import com.cs557.superClasses.Location;
import com.cs557.uav.ClimbSpeed;
import com.cs557.uav.LocationUav;
import com.cs557.uav.OrientationUav;
import com.cs557.uav.Target;
import com.cs557.uav.Uav;

/**
 * Parses messages received through the network in the Paparazzi xml format
 * 
 * @author Isabelle Santos
 *
 */
public class Parser extends Observable {

	private Uav clone;

	// Flags indicating changes
	private boolean engineStatusChange;
	private boolean flightParamChange;
	private boolean targetChange;
	private boolean newAircraft;
	private boolean endAircraft;
	private boolean readListAircraft;
	private boolean configChange;

	/* ****************
	 * CONSTRUCTORS 
	 * ****************
	 */
	
	/**
	 * Create a parser instance with flags to false
	 * 
	 * @param fleet
	 */
	public Parser(Fleet fleet) {
		engineStatusChange = false;
		flightParamChange = false;
		targetChange = false;
		newAircraft = false;
		endAircraft = false;
		readListAircraft = false;
		configChange = false;

		addObserver(fleet);
		clone = new Uav("");// the constructor needs an empty id
	}
	
	/* ****************
	 * METHODS 
	 * ****************
	 */

	/**
	 * 
	 * @return the clone
	 */
	public Uav getClone() {
		return clone;
	}

	/**
	 * 
	 * @return the flag configChange
	 */
	public boolean getConfigChange() {
		return configChange;
	}

	/**
	 * @return the flag engStatutChange
	 */
	public boolean getEngineStatusChange() {
		return engineStatusChange;
	}

	/**
	 * 
	 * @return the flag targetChange
	 */
	public boolean getTargetChange() {
		return targetChange;
	}

	/**
	 * 
	 * @return the flag flightParamChange
	 */
	public boolean getFlightParamChange() {
		return flightParamChange;
	}

	/**
	 * @return the flag newAircraft
	 */
	public boolean getNewAircraft() {
		return newAircraft;
	}

	/**
	 * 
	 * @return the flag endAircraft
	 */
	public boolean getEndAircraft() {
		return endAircraft;
	}

	/**
	 * 
	 * @return the flag readListAircraft
	 */
	public boolean getReadListAircraft() {
		return readListAircraft;
	}

	/**
	 * Set all the flags to false.
	 */
	public void resetFlags() {
		engineStatusChange = false;
		flightParamChange = false;
		newAircraft = false;
		endAircraft = false;
		readListAircraft = false;
		targetChange = false;
		configChange = false;
		this.clearChanged();
	}

	/**
	 * 
	 * @return is a flag lifted
	 */
	public boolean changesUsed() {
		return !(engineStatusChange || flightParamChange || newAircraft
				|| endAircraft || readListAircraft || targetChange || configChange);
	}


	/**
	 * Parse the message, put the new data into the clone.
	 * 
	 * @param message
	 */
	public void parse(String message) {

		if (changesUsed()) {

			// Parse CONFIG message
			if (message.matches("(^ground CONFIG .*)")) {
				String[] parsedData = message.split(" "); // tokenize
				configChange = true;
				
				// update data in clone
				clone.setId(parsedData[2]);
				clone.setName(parsedData[8]);
				clone.setColor(parsedData[7]);
				SharedInformation.getFleet().update(this, null);
				setChanged();
			}// END OF CONFIG

			// Parse NAV_STATUS message
			if (message.matches("(^ground NAV_STATUS .*)")) {
				String[] parsedData = message.split(" "); // tokenize
				targetChange = true;
				
				// update data in clone
				clone.setId(parsedData[2]);
				ClimbSpeed targetClimb = new ClimbSpeed(
						Double.parseDouble(parsedData[9]));
				Location targetLocation = new Location(
						Double.parseDouble(parsedData[7]),
						Double.parseDouble(parsedData[8]),
						Double.parseDouble(parsedData[10]));

				Target target = new Target(targetLocation, targetClimb);
				clone.setTarget(target, clone.getLocation());

				this.notifyObservers();
				SharedInformation.getFleet().update(this, null);
				setChanged();
			}// END OF NAV_STATUS

			// Parse ENGINE_STATUS messages
			if (message.matches("(^ground ENGINE_STATUS .*)")) {
				String[] parsedData = message.split(" "); // tokenize
				engineStatusChange = true;
				
				// update data in clone
				clone.setId(parsedData[2]);
				clone.setBattery(Double.parseDouble(parsedData[7]));
				clone.setThrottle(Double.parseDouble(parsedData[3]));

				this.notifyObservers();
				setChanged();
				SharedInformation.getFleet().update(this, null);
			}// END OF ENGINE_STATUS

			// Parse FLIGHT_PARAM messages
			if (message.matches("(^ground FLIGHT_PARAM .*)")) {

				String[] parsedData = message.split(" ");// tokenize
				flightParamChange = true;
				
				// update data in clone
				clone.setId(parsedData[2]);
				LocationUav location = new LocationUav(
						Double.parseDouble(parsedData[6]),
						Double.parseDouble(parsedData[7]),
						Double.parseDouble(parsedData[10]),
						Double.parseDouble(parsedData[12]));
				clone.setLocation(location, location);
				clone.getTrueAirSpeed().setValue(
						Double.parseDouble(parsedData[15]));
				clone.setClimbSpeed(new ClimbSpeed(Double
						.parseDouble(parsedData[11])));
				clone.getGroundSpeed().setValue(
						Double.parseDouble(parsedData[8]));
				OrientationUav orientation = new OrientationUav(
						Double.parseDouble(parsedData[4]),
						Double.parseDouble(parsedData[3]),
						Double.parseDouble(parsedData[5]));
				clone.setOrientation(orientation);

				
				setChanged();
				SharedInformation.getFleet().update(this, null);
				this.notifyObservers();
			}// END OF FLIGHT_PARAM

			// Parse NEW_AIRCRAFT messages
			if (message.matches("(^ground NEW_AIRCRAFT .*)")) {
				String[] parsedData = message.split(" ");// tokenize
				
				// update data in clone
				newAircraft = true;
				clone.setId(parsedData[2]);
				
				SharedInformation.getFleet().update(this, null);
				this.notifyObservers();
			}// END OF NEW_AIRCRAFT

			// Parse AIRCRAFT_DIE messages
			if (message.matches("(^ground AIRCRAFT_DIE .*)")) {
				String[] parsedData = message.split(" ");// tokenize
				endAircraft = true;
				
				// update data in clone
				clone.setId(parsedData[2]);
				
				setChanged();
				SharedInformation.getFleet().update(this, null);
				this.notifyObservers();
			}// END OF AIRCRAFT_DIE

			// Parse AIRCRAFT messages
			if (message.matches("(^ground AIRCRAFTS .*)")) {
				String[] parsedData = message.split(" ");// tokenize
				int nbAircraft = parsedData.length - 1;
				
				// update data in clone
				for (int i = 1; i <= nbAircraft; i++) {
					if (changesUsed()) {
						readListAircraft = true;
						clone.setId(parsedData[i + 1]);
						
						setChanged();
						SharedInformation.getFleet().update(this, null);
						this.notifyObservers();
					}
				}
			}
		}
	}

}