package labovi.deveti.treci;

public class Test {
    public static void main(String[] args) {
        A a1 = new A(1, true, "test");
        B b1 = new B(2.0, 1.1f);

        System.out.println(a1);
        System.out.println(b1);

        SerializationUtil.saveObject(a1, "a.dat");
        SerializationUtil.saveObject(b1, "b.dat");

        A a2 = SerializationUtil.readObject("a.dat");
        B b2 = SerializationUtil.readObject("b.dat");

        System.out.println(a2);
        System.out.println(b2);
    }
}
