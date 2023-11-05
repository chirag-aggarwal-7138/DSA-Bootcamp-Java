import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        
    }

    public static int[] radixSort(int[] nums) {
        if (nums.length < 2) {
            return nums;
        }

        int max = Arrays.stream(nums).max().getAsInt();

        for (int exp = 1; exp / 10 > 0; exp *= 10) {
            countSort(nums, exp);
        }
    }

    private static void countSort(int[] nums, int exp) {
        int n = nums.length;
        int[] output = new int[n];
        int count = new int[10];
        
        for (int i = 0; i < n; i++) {
            count[(nums[i] / exp) % 10]++;  
        }
    }
}