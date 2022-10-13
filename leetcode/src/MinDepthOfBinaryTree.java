public class MinDepthOfBinaryTree extends BaseTreeNode {
    public static void main(String[] args) {
        MinDepthOfBinaryTree instance = new MinDepthOfBinaryTree();
        System.out.println(instance.minDepth(generateTreeNode(new Integer[]{3,9,20,null,null,15,7})));
        System.out.println(instance.minDepth(generateTreeNode(new Integer[]{2,null,3,null,4,null,5,null,6})));
    }
    public int minDepth(TreeNode root) {
        return visit(root);
    }
    private int visit(TreeNode node) {
        int depth = 0;
        if (node != null) {
            if (node.left == null && node.right == null) {
                depth = 1;
            } else {
                int leftDepth = 0;
                int rightDepth = 0;
                if (node.left != null) {
                    leftDepth = visit(node.left);
                }
                if (node.right != null) {
                    rightDepth = visit(node.right);
                }
                depth = leftDepth == 0 ? rightDepth + 1 : rightDepth == 0 ? leftDepth + 1 : Math.min(leftDepth, rightDepth) + 1;
            }
        }
        return depth;
    }
}
