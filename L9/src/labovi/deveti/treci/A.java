package labovi.deveti.treci;
import java.io.Serializable;

public class A implements Serializable {
    public Integer a;
    public Boolean b;
    public String c;

    public A(Integer a, Boolean b, String c) { this.a = a; this.b = b; this.c = c; }

    @Override
    public String toString() {
        return "A{" +
                "a=" + a +
                ", b=" + b +
                ", c='" + c + '\'' +
                '}';
    }
}
