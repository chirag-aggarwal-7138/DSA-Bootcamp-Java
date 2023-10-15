import java.util.Arrays;

public class QuickSortRecursion {
    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        quickSortRecursion(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    static void quickSortRecursion(int[] nums, int low, int high) {
        if (low > high) {
            return;
        }

        int s = low;
        int e = high;
        int pivot = s + (e - s) / 2;

        while (s <= e) {
            if (nums[s] < nums[pivot]) {
                s++;
            }

            if (nums[e] > nums[pivot]) {
                e--;
            }

            if (s <= e) {
                int temp = nums[s];
                nums[s] = nums[e];
                nums[e] = temp;
                s++;
                e--;
            }
        }

        quickSortRecursion(nums, low, e);
        quickSortRecursion(nums, s, high);

        return;
    }
}
