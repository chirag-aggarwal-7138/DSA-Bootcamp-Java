import java.util.Arrays;
import java.util.HashMap;
/**
 * This class provides two implementations of Count Sort algorithm.
 */
/**
 * This class provides two implementations of Count Sort algorithm to sort an integer array.
 */
public class CountSort {

    /**
     * This method implements Count Sort algorithm using an array as a helper.
     * 
     * @param nums The input array to be sorted.
     * @return The sorted array.
     */
    public static int[] countSort(int[] nums) {
        if (nums.length < 2) {
            return nums;
        }

        // Find the largest element in the array
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > largest) {
                largest = nums[i];
            }
        }

        // Create a helper array of size largest+1 and initialize all elements to 0
        int[] helper = new int[largest + 1];

        // Count the frequency of each element in the input array and store it in the helper array
        for (int i = 0; i < nums.length; i++) {
            helper[nums[i]]++;
        }

        // Overwrite the input array with the sorted elements from the helper array
        int k = 0;
        for (int i = 0; i <= largest; i++) {
            while (helper[i] > 0) {
                nums[k] = i;
                k++;
                helper[i]--;
            }
        }

        return nums;
    }

    /**
     * This method implements Count Sort algorithm using a HashMap as a helper.
     * 
     * @param nums The input array to be sorted.
     * @return The sorted array.
     */
    static int[] countSortHashMap(int[] nums) {
        if (nums.length < 2) {
            return nums;
        }

        // Create a HashMap to store the frequency of each element in the input array
        HashMap<Integer, Integer> map = new HashMap<>();

        // Find the largest element in the array
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > largest) {
                largest = nums[i];
            }
        }

        // Count the frequency of each element in the input array and store it in the HashMap
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        // Overwrite the input array with the sorted elements from the HashMap
        int k = 0;
        for (int i = 0; i <= largest; i++) {
            if (map.containsKey(i)) {
                while (map.get(i) > 0) {
                    nums[k] = i;
                    k++;
                    map.put(i, map.get(i) - 1);
                }
            }
        }

        return nums;
    }

    /**
     * This is the main method which calls both implementations of Count Sort algorithm.
     * 
     * @param args Unused.
     */
    public static void main(String[] args) {
        int[] nums = { 5, 1, 3, 8, 6, 2, 3, 4 };
        System.out.println(Arrays.toString(countSortHashMap(nums)));
        System.out.println(Arrays.toString(countSort(nums)));
    }
}