import java.util.Arrays;

public class Search2DMatrix {
    
    public static void main(String[] args) {
        int[][] nums = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
        System.out.println(Arrays.toString(search(nums, 13)));
    }

    /**
     * Searches for a target value in a 2D matrix of integers.
     * @param nums the 2D matrix of integers to search in
     * @param target the target value to search for
     * @return an array containing the row and column indices of the target value if found, or null if not found
     */
    public static int[] search(int[][] nums, int target) {
        // Initialize row index to 0
        int r = 0;
        // Initialize column index to the last column of the first row
        int c = nums[0].length - 1;
    
        // Loop until either the row index is greater than or equal to the number of rows or the column index is less than 0
        while (r < nums.length && c > 0) {
            // If the current element is greater than the target, move left by decrementing the column index
            if (nums[r][c] > target) {
                c--;
            // If the current element is less than the target, move down by incrementing the row index
            } else if (nums[r][c] < target) {
                r++;
            // If the current element is equal to the target, return the row and column indices as an array
            } else {
                return new int[] {r, c};
            }
        }
        // If the target is not found, return null
        return null;
    }
}
