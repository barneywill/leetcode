public class ConstructBinaryTreeFromInorderAndPostorderTraversal extends BaseTreeNode {
    public static void main(String[] args) {
        ConstructBinaryTreeFromInorderAndPostorderTraversal instance = new ConstructBinaryTreeFromInorderAndPostorderTraversal();
        printTreeNode(instance.buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3}));
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return generate(inorder, 0, inorder.length - 1, postorder, postorder.length - 1);
    }
    private TreeNode generate(int[] inorder, int start, int end, int[] postorder, int current) {
        TreeNode result = null;
        if (start <= end && current >= 0) {
            int target = -1;
            for (int i = start; i <= end; i++) {
                if (inorder[i] == postorder[current]) {
                    target = i;
                    break;
                }
            }
            if (target >= 0) {
                result = new TreeNode(postorder[current],
                        generate(inorder, start, target - 1, postorder, current - 1),
                        generate(inorder, target + 1, end, postorder, current - 1)
                );
            } else {
                result = generate(inorder, start, end, postorder, current - 1);
            }
        }
        return result;
    }
}
