public class NewtonRapsonMethod {
    public static void main(String[] args) {
        // This is a method to calculate the square root of a number
        System.out.println(newtonRapsonMethod(36));
    }

    static double newtonRapsonMethod(double n) {
        double x = n;
        double root;

        while (true) {
            root = 0.5 * (x + (n / x));

            if (Math.abs(root - x) < 0.001) {
                break;
            }

            x = root;
        }
        return root;
    }
}
