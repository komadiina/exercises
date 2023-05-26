package org.unibl.etf.pj2.Predmet;

import java.lang.Math;
import org.unibl.etf.pj2.Izuzetak.PredmetException;

public class Sfera extends Predmet {
	private Double r;

	public Sfera(Double spTezina, Double r) throws PredmetException {
		super(spTezina);
		
		if (r < 1 || r > 100) {
			throw new PredmetException("Predmet nije validnih dimenzija!"); 
		}	
	
		this.r = r;
	}

	// Setters and getters
	public void setR(Double r) throws PredmetException { 
		if (r < 1 || r > 100) {
			throw new PredmetException("Predmet nije validnih dimenzija!");	}
	
		this.r = r; 	
	}
	public Double getR() { return this.r; }

	public void print() {
		System.out.println("[SFERA]:\n" + "ID: " + super.id.toString() + "\nSpec. tezina: " + this.spTezina.toString() + "\nPoluprecnik: " + this.r.toString());
	}

	public Double zapremina() {
		return (4.0/3.0) * Math.PI * Math.pow(this.r, 3);
	}
}