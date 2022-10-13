public class ConstructBinaryTreeFromPreorderAndInorderTraversal extends BaseTreeNode {
    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderAndInorderTraversal instance = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
        printTreeNode(instance.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7}));
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return generate(inorder, 0, inorder.length - 1, preorder, 0);
    }
    private TreeNode generate(int[] inorder, int start, int end, int[] preorder, int current) {
        TreeNode result = null;
        if (start <= end && current < preorder.length) {
            int target = -1;
            for (int i = start; i <= end; i++) {
                if (inorder[i] == preorder[current]) {
                    target = i;
                    break;
                }
            }
            if (target >= 0) {
                result = new TreeNode(preorder[current],
                        generate(inorder, start, target - 1, preorder, current + 1),
                        generate(inorder, target + 1, end, preorder, current + 1)
                );
            } else {
                result = generate(inorder, start, end, preorder, current + 1);
            }
        }
        return result;
    }
}
