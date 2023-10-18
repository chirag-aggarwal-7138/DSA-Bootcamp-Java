import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetIterationArray {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 2 };
        List<List<Integer>> lst = subSetDuplicate(nums);
        for (List<Integer> i : lst) {
            System.out.println(i);
        }
    }

    /**
     * This method takes an integer array as input and returns a list of all
     * possible subsets of the array.
     * The subsets are returned as a list of lists, where each inner list represents
     * a subset.
     * The method uses an iterative approach to generate the subsets.
     *
     * @param nums the input integer array
     * @return a list of all possible subsets of the input array
     */
    static List<List<Integer>> subSet(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();

        subsets.add(new ArrayList<>());

        for (int i : nums) {
            int size = subsets.size();
            for (int j = 0; j < size; j++) {
                List<Integer> currentSubset = new ArrayList<>(subsets.get(j));
                currentSubset.add(i);
                subsets.add(currentSubset);
            }
        }
        return subsets;
    }

    /**
     * This method returns all possible subsets of the given integer array,
     * including duplicates.
     * The subsets are returned as a list of lists of integers.
     * 
     * @param nums The input integer array
     * @return A list of all possible subsets of the input array, including
     *         duplicates
     */
    static List<List<Integer>> subSetDuplicate(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        Arrays.sort(nums);

        int startIndex = 0, endIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            startIndex = 0;
            if (i > 0 && nums[i] == nums[i - 1]) {
                startIndex = endIndex + 1;
            }
            endIndex = subsets.size() - 1;
            for (int j = startIndex; j <= endIndex; j++) {
                List<Integer> currentSubset = new ArrayList<>(subsets.get(j));
                currentSubset.add(nums[i]);
                subsets.add(currentSubset);
            }
        }
        return subsets;
    }
}
