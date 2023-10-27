import java.util.Arrays;

public class TwoStacksHackerRank {
    public static void main(String[] args) {
        
    }

    public static int twoStacks(int maxSum, int[] a, int[] b, int sum, int count) {
        if (sum > maxSum) {
            return count;
        }

        if (a.length == 0 || b.length == 0) {
            return count;
        }
        
        int first = twoStacks(maxSum, Arrays.copyOfRange(a, 1, a.length), b, sum + a[0], count + 1);
        int second = twoStacks(maxSum, a, Arrays.copyOfRange(b, 1, b.length), sum + b[0], count + 1);

        return Math.max(first, second);
    }
}
