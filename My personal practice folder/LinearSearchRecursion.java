import java.util.ArrayList;

public class LinearSearchRecursion {
    public static void main(String[] args) {
        int[] nums = {1, 5, 7 ,3 , 8, 7, 7};
        System.out.println(linearSearchRecursion4(nums, 7, 0));
    }

    static boolean linearSearchRecursion(int[] nums, int target, int i) {
        if (i == nums.length) {
            return false;
        }

        if (nums[i] == target ) {
            return true;
        }

        return linearSearchRecursion(nums, target, ++i);

    }   
    
    static ArrayList<Integer> linearSearchRecursion2(int[] nums, int target, int i, ArrayList<Integer> list) {
        if (i == nums.length) {
            return list;
        }

        if (nums[i] == target ) {
            list.add(i);
        }

        return linearSearchRecursion2(nums, target, ++i, list);

    }

    static ArrayList<Integer> linearSearchRecursion3(int[] nums, int target, int i) {
        ArrayList<Integer> list = new ArrayList<>();

        if (i == nums.length) {
            return list;
        }

        ArrayList<Integer> lst = linearSearchRecursion3(nums, target, i + 1);

        if (nums[i] == target) {
            lst.add(i);
        }

        return lst;
    }

    static ArrayList<Integer> linearSearchRecursion4(int[] nums, int target, int i) {
        ArrayList<Integer> list = new ArrayList<>();

        if (i == nums.length) {
            return list;
        }

        if (nums[i] == target) {
            list.add(i);
        }

        ArrayList<Integer> lst = linearSearchRecursion4(nums, target, i + 1);

        // lst.addAll(list);
        list.addAll(lst);

        // return lst;
        return list;
    }
}
