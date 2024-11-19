import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal extends BaseTreeNode {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        inorderTravel(result, root);
        return result;
    }
    private void inorderTravel(List<Integer> result, TreeNode node) {
        if (node != null) {
            inorderTravel(result, node.left);
            result.add(node.val);
            inorderTravel(result, node.right);
        }
    }
}
