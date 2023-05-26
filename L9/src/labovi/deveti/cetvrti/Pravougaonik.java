package labovi.deveti.cetvrti;

public class Pravougaonik extends Oblik{
    public Integer a, b;

    public Pravougaonik(Integer a, Integer b) {
        super();

        this.a = a;
        this.b = b;
    }

    public void iscrtaj() {
        System.out.println("ovo je pravougaonik...");
    }

    public Double povrsina() {
        return this.a.doubleValue() * this.b.doubleValue();
    }
}
