public class Bitwise {
    public static void main(String[] args) {
        int unique = 0;

        for (int i : nums) {
            unique = unique ^ i;
        }
        return unique;
    }

    public static int[][] image(int[][] image) {
        for (int[] nums : image) {
            int s = 0;
            int e = nums.length - 1;

            while (s < e) {
                int temp = nums[s] ^ 1;
                nums[s] = nums[e] ^ 1;
                nums[e] = temp;

                s++;
                e--;
            }
        }
    }

    public static int happyno(int n {
        int base = 5;
        int ans = 0;
        while (n > 0) {
            int last = n & 1;
            n = n >> 1;
            ans += last * base;
            base *= base;
        }
    })
}
