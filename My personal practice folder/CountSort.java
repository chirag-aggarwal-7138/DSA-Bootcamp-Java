import java.util.Arrays;
import java.util.HashMap;

public class CountSort {
    public static void main(String[] args) {
        int[] nums = {5, 1, 3, 8, 6, 2, 3, 4};
        System.out.println(Arrays.toString(countSortHashMap(nums)));
        System.out.println(Arrays.toString(countSort(nums)));

    }

    public static int[] countSort(int[] nums) {
        if (nums.length < 2) {
            return nums;
        }

        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > largest) {
                largest = nums[i];
            }
        }

        int[] helper = new int[largest + 1];

        for (int i = 0; i < nums.length; i++) {
            helper[nums[i]]++;
        }

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

    static int[] countSortHashMap(int[] nums) {
        if (nums.length < 2) {
            return nums;
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > largest) {
                largest = nums[i];
            }
        }

        for (int i : nums) {
            if (map.containsKey(i))  {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        
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
}