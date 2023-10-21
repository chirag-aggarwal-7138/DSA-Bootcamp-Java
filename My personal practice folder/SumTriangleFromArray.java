import java.util.Arrays;

public class SumTriangleFromArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        sum(nums);
    }

    static void sum(int[] nums) {
        if (nums.length == 0) {
            return;
        }

        int[] arr = new int[nums.length - 1];
        for (int i = 0; i < nums.length - 1; i++) {
            arr[i] = nums[i] + nums[i + 1];
        }

        
        sum(arr);
        System.out.println(Arrays.toString(nums));
    }
}
