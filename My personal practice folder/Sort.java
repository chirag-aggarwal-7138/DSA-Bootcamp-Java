import java.util.*;

class Sort {
    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 1, 4};
        System.out.println(Arrays.toString(cycleSort(nums)));
        
    }

    // Insertion Sort
    public static int[] insertionSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
        return nums;
    }

    // Selection Sort
    public static int[] selectionSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int last = nums.length - i - 1;
            int max = max(nums, last);

            int temp = nums[max];
            nums[max] = nums[last];
            nums[last] = temp;
        }
        return nums;
    }

    public static int max(int[] nums, int last) {
        int max = 0;
        for (int i = 1; i <= last; i++) {
            if (nums[i] > nums[max]) {
                max = i;
            }
        }
        return max;
    }

    // Bubble Sort
    public static int[] bubbleSort(int[] nums) {
        boolean sorted;
        for (int i = 0; i < nums.length - 1; i++) {
            sorted = false;
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    sorted = true;
                }
            }
            if (!sorted) {
                return nums;
            }
        }
        return nums;
    }

    // Cycle Sort
    public static int[] cycleSort(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correct = nums[i] - 1;
            if (nums[i] != nums[correct]) {
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            } else {
                i++;
            }
        }
        return nums;
    }
}