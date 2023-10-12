public class Fact {
    public static void main(String[] args) {
        // fact2(5, 1);
        System.out.println(fact2(5, 1));
    }

    // Tail recursion
    static int fact(int n) {
        if (n == 1) {
            return 1;
        }

        return n * fact(n - 1);
    }

    // Head recursion
    static int fact2(int n, int product) {
        if (n == 1) {
            return product;
        }

        // product *= n;
        System.out.println(product);
        return fact2(n - 1, product * n);
    }
}
