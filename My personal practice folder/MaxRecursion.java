public class MaxRecursion {
    public static void main(String[] args) {
        int[] nums = {2, 6, 1, 12};
        System.out.println(max(nums, 0, 0));
    }

    static int max(int[] nums, int i, int max) {
        if (i == nums.length) {
            return max;
        }

        if (nums[i] > max) {
            max = nums[i];
        }

        return max(nums, i + 1, max);
    }
}
