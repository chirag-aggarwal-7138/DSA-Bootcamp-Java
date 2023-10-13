import java.util.Arrays;

public class BubbleSortRecursion {
    public static void main(String[] args) {
        int[] nums = {3, 1, 2 ,4};
        System.out.println(Arrays.toString(bubbleSortRecursion(nums, nums.length - 2, 0)));
    }

    static int[] bubbleSortRecursion(int[] nums, int i, int j) {
        if (i == 0) {
            return nums;
        }

        if (nums[j] > nums[j + 1]) {
            swap(nums, j, j + 1);
        }

        if (j == i) {
            return bubbleSortRecursion(nums, i - 1, 0);
        }

        return bubbleSortRecursion(nums, i, j + 1);
    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
