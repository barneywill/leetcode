public class ConvertSortedArrayToBinarySearchTree extends BaseTreeNode {
    public static void main(String[] args) {
        ConvertSortedArrayToBinarySearchTree instance = new ConvertSortedArrayToBinarySearchTree();
        printTreeNode(instance.sortedArrayToBST(new int[]{-10,-3,0,5,9}));
        printTreeNode(instance.sortedArrayToBST(new int[]{1,3}));
        printTreeNode(instance.sortedArrayToBST(new int[]{-1,0,1,2}));
        printTreeNode(instance.sortedArrayToBST(new int[]{0,1,2,3,4,5,6,7}));
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return generateTreeNode(nums, 0, nums.length - 1);
    }
    private TreeNode generateTreeNode(int[] nums, int start, int end) {
        TreeNode result = null;
        if (start == end) {
            result = new TreeNode(nums[start]);
        } else if (start + 1 == end) {
            result = new TreeNode(nums[start], null, new TreeNode(nums[end]));
        } else if (start + 2 == end) {
            result = new TreeNode(nums[start + 1], new TreeNode(nums[start]), new TreeNode(nums[end]));
        } else {
            int middle = (end + start) / 2;
            result = new TreeNode(nums[middle], generateTreeNode(nums, start, middle - 1), generateTreeNode(nums, middle + 1, end));
        }
        return result;
    }
}
