import java.util.Arrays;

public class Sqrt {
    public static void main(String[] args) {
        // System.out.println(isPrime(15));
        // for (int i = 1; i <= 40; i++) {
        //     System.out.println(i + " " + isPrime(i));
        // }

        int n = 40;
        boolean[] arr = new boolean[n + 1];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = true;
        }
        // System.out.println(Arrays.toString(arr));
        sieve(n, arr);
        for (int i = 1; i < arr.length; i++) {
            System.out.println(i + " " + arr[i]);
        }
    }

    static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    static void sieve(int n, boolean[] arr) {
        for (int i = 1; i * i <= n; i++) {
            if (isPrime(i)) {
                arr[i] = true;
                for (int j = 2 * i; j < arr.length; j = j + i) {
                    arr[j] = false;
                }
            } else {
                arr[i] = false;
            }
        }
    }
}
