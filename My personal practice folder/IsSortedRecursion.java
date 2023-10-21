public class IsSortedRecursion {
    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 4, 5};
        System.out.println(isSorted(nums, 0));
    }

    static boolean isSorted(int[] nums, int i) {
        if (i + 1 == nums.length - 1) {
            return true;
        }

        if (nums[i] < nums[i + 1]) {
            return isSorted(nums, i + 1);
        }

        return false;
    }
}
