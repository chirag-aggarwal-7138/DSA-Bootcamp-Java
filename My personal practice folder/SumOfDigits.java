public class SumOfDigits {
    public static void main(String[] args) {
        int ans = sumOfDigits2(12345);
        System.out.println(ans);
    }

    static int sumOfDigits(int n, int sum) {
        if (n == 0) {
            return sum;
        }

        sum += n % 10;
        return sumOfDigits(n / 10, sum);
    }

    static int sumOfDigits2(int n) {
        if (n == 0) {
            return 0;
        }

        return n % 10 + sumOfDigits2(n / 10);
    }
}
