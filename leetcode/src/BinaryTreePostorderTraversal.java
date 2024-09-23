import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal extends BaseTreeNode {
    public static void main(String[] args) {
        BinaryTreePostorderTraversal instance = new BinaryTreePostorderTraversal();
        System.out.println(instance.postorderTraversal(generateTreeNode(new Integer[]{1, null, 2, 3})));
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        postorderTraversal(root, result);
        return result;
    }
    private void postorderTraversal(TreeNode node, List<Integer> previousResult) {
        if (node != null) {
            postorderTraversal(node.left, previousResult);
            postorderTraversal(node.right, previousResult);
            previousResult.add(node.val);
        }
    }
}
