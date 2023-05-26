package labovi.deveti.drugi;

public class Kutija<T> {
    private T atribut;

    public Kutija(T atribut) {
        this.atribut = atribut;
    }

    public T getAtribut() {
        return atribut;
    }

    public void setAtribut(T atribut) {
        this.atribut = atribut;
    }
}
