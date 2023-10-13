public class IsSortedArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 6, 5};
        System.out.println(isSortedArray2(nums, 0));
    }

    static boolean isSortedArray(int[] nums, int i) {
        if (i == nums.length - 1) {
            return true;
        }

        return nums[i] < nums[i + 1] && isSortedArray(nums, i + 1);
    }

    static boolean isSortedArray2(int[] nums, int i) {
        if (i == nums.length - 1) {
            return true;
        }

        if (nums[i] < nums[i + 1]) {
            return isSortedArray2(nums, ++i);
        }

        return false;
    }
}
