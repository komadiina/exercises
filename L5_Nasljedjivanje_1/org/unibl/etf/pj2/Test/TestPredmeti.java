package org.unibl.etf.pj2.Test;

import org.unibl.etf.pj2.Predmet.*;
import org.unibl.etf.pj2.Izuzetak.PredmetException;

public class TestPredmeti {
	public static void main(String[] args) {
		try{ 
		Sfera sf1 = new Sfera(1.05, 1.0);
		Sfera sf2 = new Sfera(0.99, 2.0);
	
		Kvadar kv1 = new Kvadar(0.801, 2.0, 4.0, 6.0);
		Kvadar kv2 = new Kvadar(0.945, 1.0, 1.0, 1.0);

		System.out.println("-----> sf1: ");
		System.out.println(sf1.getR());
		System.out.println(sf1.zapremina());
		System.out.println(sf1.tezina());
		sf1.print();
		
		System.out.println("-----> sf2: ");
		System.out.println(sf2.getR());
		System.out.println(sf2.zapremina());
		System.out.println(sf2.tezina());
		sf2.print();		
	
		System.out.println("sf1 > sf2: " + Predmet.poredjenje(sf1, sf2));
		
		System.out.println("-----> kv1: ");
		System.out.println(kv1.getA().toString());
		System.out.println(kv1.zapremina());
		System.out.println(kv1.tezina());
		kv1.print();	

		System.out.println("-----> kv2: ");
		System.out.println(kv2.getA().toString());
		System.out.println(kv2.zapremina());
		System.out.println(kv2.tezina());
		kv2.print();	
	
		System.out.println("kv1 > kv2: " + Predmet.poredjenje(kv1, kv2)); 
} catch (PredmetException e) {
	e.printStackTrace();
}
	}
}