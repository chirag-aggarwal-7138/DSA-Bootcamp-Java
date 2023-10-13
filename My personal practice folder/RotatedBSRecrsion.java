public class RotatedBSRecrsion {
    public static void main(String[] args) {
        int[] nums = {5, 6, 7, 9, 1, 2, 3};
        System.out.println(rotatedBSRecrsion(nums, 1));
    }

    static int rotatedBSRecrsion(int[] nums, int target) {
        int pivot = pivot(nums, 0, nums.length - 1);

        int ans = binarySearch(nums, 0, pivot, target);
        if (ans != -1) {
            return ans;
        }
        return binarySearch(nums, pivot + 1, nums.length - 1, target);
    }

    static int pivot(int[] nums, int s, int e) {
        int m = s + (e - s) / 2;

        if (nums[m] > nums[m + 1]) {
            return m;
        }

        if (nums[m] < nums[m - 1]) {
            return m - 1;
        }

        if (nums[m] > nums[nums.length - 1]) {
            return pivot(nums, m + 1, e);
        }

        return pivot(nums, s, m);
    }

    static int binarySearch(int[] nums, int s, int e, int target) {
        int m = s + (e - s) / 2;

        if (s > e) {
            return -1;
        }

        if (nums[m] == target) {
            return m;
        }

        if (nums[m] > target) {
            return binarySearch(nums, s, m - 1, target);
        }

        return binarySearch(nums, m + 1, e, target);
    }
}
