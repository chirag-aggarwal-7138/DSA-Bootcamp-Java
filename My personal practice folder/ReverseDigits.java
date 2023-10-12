public class ReverseDigits {
    public static void main(String[] args) {
        int ans = zeros(30204, 0);
        System.out.println(ans);
    }

    static int reverseDigits(int n, int reverse) {
        if (n == 0) {
            return reverse;
        }

        reverse = reverse * 10 + (n % 10);
        return reverseDigits(n / 10, reverse);
    }

    static int reverseDigits2(int n, int reverse) {
        if (n == 0) {
            return reverse;
        }

        int pow = (int)Math.log10(n);
        reverse += (n % 10) * Math.pow(10, pow);
        return reverseDigits2(n / 10, reverse);
    }

    static int zeros(int n, int count) {
        if (n == 0) {
            return count;
        }

        if (n % 10 == 0) {
            return zeros(n / 10, ++count);
        }

        return zeros(n / 10, count);
    }
}
