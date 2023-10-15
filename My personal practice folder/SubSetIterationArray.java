import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetIterationArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> lst = subSet(nums);
        for (List<Integer> i : lst) {
            System.out.println(i);
        }
    }

    /**
     * This method takes an integer array as input and returns a list of all possible subsets of the array.
     * The subsets are returned as a list of lists, where each inner list represents a subset.
     * The method uses an iterative approach to generate the subsets.
     *
     * @param nums the input integer array
     * @return a list of all possible subsets of the input array
     */
    static List<List<Integer>> subSet(int[] nums) {
        List<List<Integer>> outer = new ArrayList<>();

        outer.add(new ArrayList<>());
        
        for (int i : nums) {
            int size = outer.size();
            for (int j = 0; j < size; j++) {
                List<Integer> internal = new ArrayList<>(outer.get(j));
                internal.add(i);
                outer.add(internal);
            }
        }
        return outer;
    }
}
