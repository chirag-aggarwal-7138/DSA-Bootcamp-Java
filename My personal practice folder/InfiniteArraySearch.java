public class InfiniteArraySearch {
    public int infiniteArraySearch(int[] nums, int target) {
        int s = 0;
        int e = 1;

        while (nums[e] < target) {
            s = e + 1;
            e = s * 2 + 1;
        }
        return binarySearch(nums, target, s, e);
    }

    public int binarySearch(int[] nums, int target, int s, int e) {
        while (s <= e) {
            int m = s + (e - s) / 2;

            if (nums[m] > target) {
                e = m - 1;
            } else if (nums[m] < target) {
                s = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }
    
}
