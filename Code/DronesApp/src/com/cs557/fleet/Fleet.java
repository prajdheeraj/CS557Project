package com.cs557.fleet;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import com.cs557.device.SurveillanceDevice;

import com.cs557.network.Parser;

import com.cs557.uav.Information;
import com.cs557.uav.Uav;

public class Fleet extends Observable implements Observer {

	private ArrayList<Uav> fleet;
	private Uav clone;
	private Parser parser;
	private Uav currentUavView;
	private Uav currentUavParser;
	private SurveillanceDevice myDevice;

	/* ****************
	 * CONSTRUCTORS 
	 * ****************
	 */
	
	/**
	 * Create an empty Fleet instance
	 * 
	 * @param myDevice
	 */
	public Fleet(SurveillanceDevice myDevice) {
		fleet = new ArrayList<Uav>(10);
		parser = new Parser(this);
		clone = parser.getClone();
		currentUavParser = new Uav("currentUavParser");
		currentUavParser = new Uav("currentUavView");
		this.myDevice = myDevice;
	}


	/* ****************
	 * METHODS 
	 * ****************
	 */
	
	/**
	 * 
	 * @param newOne
	 */
	public void setCurrentUavView(Uav newOne) {
		this.currentUavView = newOne;
	}

	/**
	 * 
	 * @return the parser
	 */
	public Parser getParser() {
		return parser;
	}

	/**
	 * Find a UAV with given id
	 * Throws exception if none found
	 * 
	 * @param id
	 * @return
	 * @throws NoSuchUavException
	 */
	public Uav getUav(String id) throws NoSuchUavException {
		Uav myUav;
		int i;

		if (fleet.isEmpty()) {
			throw new NoSuchUavException();
		} else {
			for (i = 0; i < fleet.size(); i++) {
				myUav = fleet.get(i);
				if (myUav.getId().equals(id)) {
					return myUav;
				}
			}
			throw new NoSuchUavException();
		}
	}

	/**
	 * Add a UAV to the Fleet
	 * 
	 * @param newUav
	 */
	public void addUav(Uav newUav) {
		fleet.add(newUav.clone());
	}

	/**
	 * Remove a UAV from the Fleet
	 * 
	 * @param id
	 * @throws NoSuchUavException
	 */
	public void deleteUav(String id) throws NoSuchUavException {
		fleet.remove(getUav(id));
	}

	/**
	 * Get information about the Fleet to display
	 * 
	 * @return
	 */
	public Information[] getFleetInformation() {
		int i;
		Information[] fleetCopy = new Information[fleet
				.size()];

		for (i = 0; i < fleet.size(); i++) {
			fleetCopy[i] = fleet.get(i).getInfos().clone();
		}
		return fleetCopy;
	}

	/**
	 * Get information about the Uav currently used by Parser
	 * 
	 * @return
	 */
	public Information getUavInformation() {
		return currentUavView.getInfos().clone();
	}

	/**
	 * Get Uav count from Fleet
	 * 
	 * @return
	 */
	public int getNumberUAV() {
		return fleet.size();
	}

	@Override
	public void update(Observable observable, Object data) {
		clone = parser.getClone();
		// search for the clone id in the list, and update CurrentUAV
		try {
			currentUavParser = this.getUav(clone.getId());

		} catch (NoSuchUavException e) {
			// if clone id doesn't exist, add this UAV
			currentUavParser = new Uav(clone.getId());
			addUav(currentUavParser);
		}

		// check flags
		if (parser.getEngineStatusChange()) {
			currentUavParser.updateEngine(clone);
		}
		if (parser.getFlightParamChange()) {
			currentUavParser.updateParameters(clone, myDevice.getPosition());
		}
		if (parser.getTargetChange()) {
			currentUavParser.updateTarget(clone);
		}
		if (parser.getNewAircraft()) {
			// nil
		}
		if (parser.getEndAircraft()) {
			try {
				deleteUav(clone.getId());
			} catch (NoSuchUavException e) {
				// nil
			}
		}
		if (parser.getReadListAircraft()) {
			// nil
		}
		if (parser.getConfigChange()) {
			currentUavParser.updateConfig(clone);
		}
		parser.resetFlags();
	}
	
}