package org.unibl.etf.pj2.Izuzetak;

public class PredmetException extends Exception {
	public PredmetException(String message) { super(message); }
	public PredmetException() { super("Predmet nije validnih dimenzija (1-100)!"); }
}