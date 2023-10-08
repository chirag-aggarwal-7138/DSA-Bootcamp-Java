import java.lang.*;

public class MagicNumber {
    public static void main(String[] args) {
        // System.out.println(magicNumber(6));
        System.out.println(addBinary("1010", "1011"));
    }

    public static String magicNumber(int n) {
        int sum = 0;
        int i = 1;
        while (n > 0) {
            sum += (n & 1) * (Math.pow(5, i));
            i++;
            n = n >> 1;
        }
        return Integer.toBinaryString(sum);
    }

    public static String addBinary(String a, String b) {
        int num1 = binary(a);
        int num2 = binary(b);

        return Integer.toBinaryString(num1 + num2);
    }

    static int binary(String a) {
        int n = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == '1') {
                n += 1 << i;
                System.out.println(n);
            }
        }

        return n;
    }
}