public class PrimeRecursion {
    public static void main(String[] args) {
        for (int i = 0; i <= 11; i++) {
            System.out.println(i + " " + prime(i, 2));
        }
    }

    static boolean prime(int n, int i) {
        if (n == 1) {
            return false;
        }

        if (n == 2) {
            return true;
        }

        if (n % i == 0) {
            return false;
        }

        if (i * i > n) {
            return true;
        }

        return prime(n, i + 1);
    }
}
