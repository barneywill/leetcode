public class ValidateBinarySearchTree extends BaseTreeNode {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }
    private boolean isValidBST(TreeNode treeNode, TreeNode ground, TreeNode ceiling) {
        boolean result = true;
        if (treeNode != null) {
            if (ground != null && treeNode.val <= ground.val) {
                result = false;
            } else {
                result = isValidBST(treeNode.left, ground, treeNode);
            }
            if (result) {
                if (ceiling != null && treeNode.val >= ceiling.val) {
                    result = false;
                } else {
                    result = isValidBST(treeNode.right, treeNode, ceiling);
                }
            }
        }
        return result;
    }
}
