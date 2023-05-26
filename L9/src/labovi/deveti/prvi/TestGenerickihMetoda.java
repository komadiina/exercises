package labovi.deveti.prvi;

public class TestGenerickihMetoda {
    public static <T> void printArray(T[] array) {
        for (T elem : array) {
            System.out.print(elem.toString() + " ");
        }

        System.out.println();
    }
}
