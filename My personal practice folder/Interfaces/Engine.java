public class Engine {

    try {
        int a = 1 / 0;
    } catch (ArithmeticException e) {
        System.out.println(e.getMessage());
    }
}
