public class AnimiraniFilm extends Film {
    protected String crtac;

    public AnimiraniFilm(String nazivFilma, Integer godinaObjavljivanja, String[] glumci, Double ocjena, String crtac) {
        super(nazivFilma, godinaObjavljivanja, glumci, ocjena);
        this.crtac = crtac;
    }

    @Override
    public String toString() {
        return super.toString() + "\nCrtac: " + this.crtac;
    }

    public String crtacUnazad() { return new StringBuffer(this.crtac).reverse().toString(); }
}
