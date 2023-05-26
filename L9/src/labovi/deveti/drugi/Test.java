package labovi.deveti.drugi;

public class Test {
    public static void main(String[] args) {
        Kutija<Integer> kutijicaInteger = new Kutija<>(5);
        Kutija<String> kutijicaString = new Kutija<>("pozz");

        System.out.println(kutijicaInteger.getAtribut());
        System.out.println(kutijicaString.getAtribut());

        kutijicaInteger.setAtribut(10);
//        kutijicaInteger.setAtribut("hehe");

        Kutija<Object> generalizovana = new Kutija<>(15);
        System.out.println(generalizovana.getAtribut());
        System.out.println(generalizovana.getClass());

        generalizovana.setAtribut("Hah");
        System.out.println(generalizovana.getAtribut());
        System.out.println(generalizovana.getClass());
    }
}
