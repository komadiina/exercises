package labovi.deveti.treci;

import java.io.Serializable;

public class B implements Serializable {
    public Double f;
    public Float g;

    public B(Double f, Float g) { this.f = f; this.g = g; }

    @Override
    public String toString() {
        return "B{" +
                "f=" + f +
                ", g=" + g +
                '}';
    }
}


