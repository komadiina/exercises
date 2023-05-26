package labovi.deveti.cetvrti;

public class PravougliTrougao extends Oblik {
    public Integer a, b;

    public PravougliTrougao(Integer a, Integer b) {
        super();

        this.a = a;
        this.b = b;
    }

    public void iscrtaj() {
        System.out.println("ovo je pravougli trougao...");
    }

    public Double povrsina() {
        return 0.5 * this.a * this.b;
    }
}
