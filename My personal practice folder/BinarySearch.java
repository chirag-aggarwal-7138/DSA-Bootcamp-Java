public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4 ,5 ,6 ,7 ,8 ,9 ,10};
        int target = 5;
        int ans = binarySearch(target, arr);
        System.out.println(ans);
    }

    public static int binarySearch(int target, int[] nums) {
        int s = 0;
        int e = nums.length - 1;

        while (s <= e) {
            int m = s + (e - s) / 2;
            if (target < nums[m]) {
                e = m - 1;
            } else if (target > nums[m]) {
                s = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }
    
}
