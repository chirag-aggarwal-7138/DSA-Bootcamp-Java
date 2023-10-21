public class ProductTwoRecursion {
    public static void main(String[] args) {
        System.out.println(product(5, 4, 0));
    }

    static int product(int a, int b) {
        if (b == 0) {
            return 0;
        }

        return a + product(a, b - 1);
    }

    static int product(int a, int b, int sum) {
        if (b == 0) {
            return sum;
        }

        sum += a;
        return product(a, b - 1, sum);
    }
}
