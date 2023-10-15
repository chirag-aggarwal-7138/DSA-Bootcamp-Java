import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = { 8, 3, 4, 12, 5, 6 };
        System.out.println(Arrays.toString(mergerSort2(nums, 0, nums.length - 1)));
    }

    static int[] mergerSort(int[] nums) {
        if (nums.length == 1) {
            return nums;
        }

        int[] left = mergerSort(Arrays.copyOfRange(nums, 0, nums.length / 2));
        int[] right = mergerSort(Arrays.copyOfRange(nums, nums.length / 2, nums.length));

        return merge(left, right);
    }

    static int[] merge(int[] left, int[] right) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] ans = new int[left.length + right.length];

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                ans[k] = left[i];
                i++;
            } else {
                ans[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < left.length) {
            ans[k] = left[i];
            i++;
            k++;
        }

        while (j < right.length) {
            ans[k] = right[j];
            j++;
            k++;
        }
        return ans;
    }

    static int[] mergerSort2(int[] nums, int s, int e) {
        if (s == e) {
            return s;
        }
        int m = s + (e - s) / 2;

        int left = mergerSort2(nums, 0, m - 1);
        int right = mergerSort2(nums, m, e);

        return merge(left, right);
    }
}
