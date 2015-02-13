package com.cs557.fleet;

/**
 * If a requested UAV is not found in the Fleet
 * 
 * @author Isabelle Santos
 *
 */
public class NoSuchUavException extends Exception {

	private String msg;

	/* ****************
	 * CONSTRUCTORS 
	 * ****************
	 */
	
	public NoSuchUavException() {
	}

	public NoSuchUavException(String msg) {
		this.msg = msg;
	}

}