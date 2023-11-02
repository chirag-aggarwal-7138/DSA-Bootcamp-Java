public class isPath {
    public static void main(String[] args) {
        return isPathExist(root, nums);
    }

    boolean isPathExist(TreeNode root, int[] nums) {
        if (root == null) {
            return nums.length == 0;
        }

        return recursion(null, nums, 0);
    }

    boolean recursion(TreeNode root, int[] nums, int index) {
        if (root == null) {
            return false;
        }
        
        if (index > nums.length - 1) {
            return false;
        }

        if (root.val != nums[index]) {
            return false;
        }

        if (root.right == null && root.left == null && index == nums.length - 1) {
            return true;
        }

        boolean left = recursion(root.left, nums, index + 1);
        boolean right = recursion(root.right, nums, index + 1);

        return left || right;
    }
}