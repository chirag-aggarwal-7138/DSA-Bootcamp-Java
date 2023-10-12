public class BSRecursion {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7};
        // Arrays.sort(nums);
        System.out.println(bSRecursion(nums, 5, 0, nums.length - 1));
    }

    static int bSRecursion(int[] nums, int target, int s, int e) {
        int m = s + (e - s) / 2;

        if (nums[m] == target) {
            return m;
        }

        if (nums[m] > target) {
            return bSRecursion(nums, target, s, m - 1);
        }

        return bSRecursion(nums, target, m + 1, e);
    }
}