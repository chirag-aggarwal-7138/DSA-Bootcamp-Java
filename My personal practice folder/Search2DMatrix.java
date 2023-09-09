import java.util.Arrays;

public class Search2DMatrix {
    
    public static void main(String[] args) {
        int[][] nums = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
        System.out.println(Arrays.toString(search(nums, 13)));
    }

    public static int[] search(int[][] nums, int target) {
        int r = 0;
        int c = nums[0].length - 1;

        while (r < nums.length && c > 0) {
            if (nums[r][c] > target) {
                c--;
            } else if (nums[r][c] < target) {
                r++;
            } else {
                return new int[] {r, c};
            }
        }
        return null;
    }
}
