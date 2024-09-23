import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal extends BaseTreeNode {
    public static void main(String[] args) {
        BinaryTreePreorderTraversal instance = new BinaryTreePreorderTraversal();
        System.out.println(instance.preorderTraversal(generateTreeNode(new Integer[]{1, null, 2, 3})));
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        preorderTraversal(root, result);
        return result;
    }
    private void preorderTraversal(TreeNode node, List<Integer> previousResult) {
        if (node != null) {
            previousResult.add(node.val);
            preorderTraversal(node.left, previousResult);
            preorderTraversal(node.right, previousResult);
        }
    }
}
