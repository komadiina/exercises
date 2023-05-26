package org.unibl.etf.pj2.Predmet;

public abstract class Predmet {
	protected static Integer identifikator = 1;
	protected Integer id;
	protected Double spTezina;

	public Predmet(Double spTezina) {
		id = identifikator++;
		this.spTezina = spTezina;	
	}
	
	// Setters and getters
	public void setSpTezina(Double st) { spTezina = st; }
	public Double getSpTezina() { return this.spTezina; }

	public Integer getId() { return this.id; }

	// Abstract methods
	public abstract void print();
	public abstract Double zapremina();
	
	public Double tezina() {
		return this.spTezina * this.zapremina();
	}

	public static boolean poredjenje(Predmet p1, Predmet p2) {
		return p1.zapremina() > p2.zapremina();	
	}
}