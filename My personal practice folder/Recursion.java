import java.util.ArrayList;

public class Recursion {
    public static void main(String[] args) {
        int[] nums = {5, 6, 7, 8, 9, 1, 2, 3};
        // System.out.println(reverseDigitsNum(12345, (int)Math.log10(12345) + 1));
        System.out.println(RBSRecursion(nums, 9, 0, nums.length - 1));
    }

    public static void printNumberss(int i) {
        if (i == 5) {
            System.out.println(i);
            return;
        }
        System.out.println(i);
        printNumberss(i + 1);
    }

    public static int fibo(int n) {
        if (n < 2) {
            return n;
        }

        return fibo(n - 1) + fibo(n - 2);
    }

    public static int binarySeachRecursion(int s, int e, int target, int[] nums) {
        int m = s + (e - s) / 2;

        if (nums[m] == target) {
            return m;
        }

        if (s <= e && nums[m] < target) {
            return binarySeachRecursion(m + 1, e, target, nums);
        } if (s <= e && nums[m] > target) {
            return binarySeachRecursion(s, m - 1, target, nums);
        }

        return -1;
    }

    public static int fact(int n) {
        if (n < 2) {
            return 1;
        }

        return n * fact(n - 1);
    }

    public static int sum(int n) {
        if (n < 2) {
            return 1;
        }

        return n + sum(n - 1);
    }

    public static int sumOfDigits(int n) {
        if (n == 0) {
            return 0;
        }

        return n % 10 + sumOfDigits(n / 10);
    }

    public static int productOfDigits(int n) {
        if (n == 0) {
            return 1;
        }

        return n % 10 * productOfDigits(n / 10);
    }

    public static int reverseDigits(int n, int ans) {
        if (n == 0) {
            return ans;
        }

        int rem = n % 10;
        ans = ans * 10 + rem;
        return reverseDigits(n / 10, ans);
    }

    public static int reverseDigitsNum(int n, int digits) {
        if (n == 0) {
            return 0;
        }

        return n % 10 * (int)Math.pow(10, digits - 1) + reverseDigitsNum(n / 10, digits - 1);
    }

    public static int numberOfZeros(int n, int count) {
        if (n == 0) {
            return count;
        }

        if (n % 10 == 0) {
            count++;
        }
        return numberOfZeros(n / 10, count);
    }

    public static boolean ifSortedRecursion(int[] nums, int i) {
        if (i == nums.length - 1) {
            return true;
        }

        return nums[i] < nums[i + 1] && ifSortedRecursion(nums, ++i);
    }

    public static int linearSeachRecursion(int[] nums, int i, int target) {
        if (i == nums.length) {
            return -1;
        }

        if (nums[i] == target) {
            return i;
        }
        return linearSeachRecursion(nums, ++i, target);
    }

    static ArrayList<Integer> list = new ArrayList<>();
    static void findAllIndex(int[] arr, int target, int index) {
        if (index == arr.length) {
            return;
        }
        if (arr[index] == target) {
            list.add(index);
        }
        findAllIndex(arr, target, index + 1);
    }

    public static int RBSRecursion(int[] nums, int target, int s, int e) {
        if (s > e) {
            return -1;
        }

        int m = s + (e - s) / 2;

        if (nums[m] == target) {
            return m;
        }

        if (nums[s] <= nums[m]) {
            if (target <= nums[m] && target >= nums[s]) {
                return RBSRecursion(nums, target, s, m - 1);
            }
            return RBSRecursion(nums, target, m + 1, e);
        }

        if (target >= nums[m] && target <= nums[e]) {
            return RBSRecursion(nums, target, m + 1, e);
        }

        return RBSRecursion(nums, target, s, m - 1);
    }
}
