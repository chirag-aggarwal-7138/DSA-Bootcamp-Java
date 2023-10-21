public class FactRecursion {
    public static void main(String[] args) {
        System.out.println(fact(4, 1));
    }

    static int fact(int n) {
        if (n == 1) {
            return 1;
        }

        return n * fact(n - 1);
    }

    static int fact(int n, int product) {
        if (n == 1) {
            return product;
        }
        product *= n;
        return fact(n - 1, product);
    }
}
