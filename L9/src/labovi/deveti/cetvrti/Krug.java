package labovi.deveti.cetvrti;

import java.math.*;
public class Krug extends Oblik {
    public Double poluprecnik;

    public Krug(Double poluprecnik) {
        super();

        this.poluprecnik = poluprecnik;
    }

    public void iscrtaj() {
        System.out.println("ovo je krug...");
    }

    public Double povrsina() {
        return Math.pow(this.poluprecnik, 2) * Math.PI;
    }
}
