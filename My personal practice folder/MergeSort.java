import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {2, 4, 6, 1, 5, 7};
        // System.out.println(Arrays.toString(mergeSort(nums)));
        mergeSortInplace(nums, 0, nums.length);
        System.out.println(Arrays.toString(nums));
    }

    public static int[] mergeSort(int nums[]) {
        if (nums.length == 1) {
            return nums;
        }

        int mid = nums.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(nums, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(nums, mid, nums.length));

        return merge(left, right);
    }

    // public static int[] merge(int[] nums, int[] nums) {
    //     int[] mix = new int[nums.length + nums.length];

    //     int i = 0;
    //     while (nums < nums.length && nums < nums.length) {
    //         if (nums[nums] < nums[nums]) {
    //             mix[i] = nums[nums];
    //             nums++;
    //             i++;
    //         } else {
    //             mix[i] = nums[nums];
    //             nums++;
    //             i++;
    //         }
    //     }

    //     while(nums < nums.length) {
    //         mix[i] = nums[nums];
    //         nums++;
    //         i++;
    //     }

    //     while (nums < nums.length) {
    //         mix[i] = nums[nums];
    //         nums++;
    //         i++;
    //     }
        
    //     return mix;
    // }

    public static void mergeSortInplace(int nums[], int s, int e) {
        if (e - s == 1) {
            return;
        }

        int m = s + (e - s) / 2;
        mergeSortInplace(nums, s, m);
        mergeSortInplace(nums, m, e);

        mergeInplace(nums, s, m, e);
    }

    public static void mergeInplace(int[] nums, int s, int m, int e) {
        int[] mix = new int[e - s];

        int j = m;
        int k = 0;
        int i = s;
        while (i < m && j < e) {
            if (nums[i] < nums[j]) {
                mix[k] = nums[i];
                k++;
                i++;
            } else {
                mix[k] = nums[j];
                k++;
                j++;
            }
        }

        while(i < m) {
            mix[k] = nums[i];
            k++;
            i++;
        }

        while (j < e) {
            mix[k] = nums[j];
            k++;
            j++;
        }
        
        for (int x = 0; x < mix.length; x++) {
            nums[s + x] = mix[x];
        }
    }
}
