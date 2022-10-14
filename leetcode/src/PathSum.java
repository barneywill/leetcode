public class PathSum extends BaseTreeNode {
    public static void main(String[] args) {
        PathSum instance = new PathSum();
        System.out.println(instance.hasPathSum(generateTreeNode(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,null,1}), 22));
        System.out.println(instance.hasPathSum(generateTreeNode(new Integer[]{1,2,3}), 5));
        System.out.println(instance.hasPathSum(generateTreeNode(new Integer[]{}), 0));
        System.out.println(instance.hasPathSum(generateTreeNode(new Integer[]{-2,null,-3}), -5));
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return visit(root, 0, targetSum);
    }
    private boolean visit(TreeNode node, int sum, int targetSum) {
        boolean result = false;
        if (node != null) {
            int currentSum = sum + node.val;
            if (node.left == null && node.right == null) {
                result = currentSum == targetSum;
            } else {
                if (node.left != null) {
                    result = visit(node.left, currentSum, targetSum);
                }
                if (!result && node.right != null) {
                    result = visit(node.right, currentSum, targetSum);
                }
            }
        }
        return result;
    }
}
