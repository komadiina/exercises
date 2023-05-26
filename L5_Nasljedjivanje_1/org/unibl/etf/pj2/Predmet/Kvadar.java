package org.unibl.etf.pj2.Predmet;
import org.unibl.etf.pj2.Izuzetak.PredmetException;

public class Kvadar extends Predmet {
	private Double a, b, c;
	
	public Kvadar(Double spTezina, Double a, Double b, Double c) throws PredmetException {	
		super(spTezina);

		if ((a < 1 || a > 100) || (b < 1 || b > 100) || (c < 1 || c > 100))
			throw new PredmetException("Predmet nije validnih dimenzija!");		

	
		this.a = a; this.b = b; this.c = c;
	}

	public void setA(Double a) throws PredmetException { 
		if (a < 1 || a > 100)
			throw new PredmetException("Predmet nije validnih dimenzija!");
		
		this.a = a;
	}

	public void setB(Double b) throws PredmetException  { 
		if (b < 1 || b > 100)
			throw new PredmetException("Predmet nije validnih dimenzija!");
		
		this.b = b;
	}	
	
	public void setC(Double c) throws PredmetException {
		if (c < 1 || c > 100)
			throw new PredmetException("Predmet nije validnih dimenzija!");

		this.c = c;
	}

	public Double getA() { return this.a; }
	public Double getB() { return this.b; }
	public Double getC() { return this.c; }

	@Override
	public void print() {
		System.out.println("[KVADAR]:\n" + "Spec. tezina: " + this.spTezina.toString() + "\nID: " + super.id.toString() +"\nA: " + this.a.toString() + "\nB: " + this.b.toString() + "\nC: " + this.c.toString());
	}

	@Override
	public Double zapremina() {
		return this.a * this.b * this.c;
	}
}