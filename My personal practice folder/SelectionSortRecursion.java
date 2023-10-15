import java.util.*;

public class SelectionSortRecursion {
    public static void main(String[] args) {
        int[] nums = { 3, 1, 2, 5 };
        System.out.println(Arrays.toString(selectionSortRecursion(nums, nums.length - 2, 0, 0)));
    }

    static int[] selectionSortRecursion(int[] nums, int i, int j, int max) {
        if (i == 0) {
            return nums;
        }

        if (nums[j] > nums[max]) {
            max = j;
        }

        if (i == j) {
            int temp = nums[max];
            nums[max] = nums[j];
            nums[j] = temp;
            return selectionSortRecursion(nums, i - 1, 0, max);
        }

        return selectionSortRecursion(nums, i, j + 1, max);
    }
}
