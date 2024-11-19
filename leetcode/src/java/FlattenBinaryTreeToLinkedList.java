import java.util.ArrayList;
import java.util.List;

public class FlattenBinaryTreeToLinkedList extends BaseTreeNode {
    public static void main(String[] args) {
        FlattenBinaryTreeToLinkedList instance = new FlattenBinaryTreeToLinkedList();
        TreeNode node = generateTreeNode(new Integer[]{1,2,5,3,4,null,6});
        instance.flatten(node);
        printTreeNode(node);
        node = generateTreeNode(new Integer[]{1,2,5,3,4,null,6});
        instance.flatten(node);
        printTreeNode(node);
    }
    public void flatten(TreeNode root) {
        List<Integer> list = visit(root);
        if (!list.isEmpty()) {
            root.left = null;
            TreeNode current = root;
            for (int i = 1; i < list.size(); i++) {
                TreeNode node = new TreeNode(list.get(i));
                current.right = node;
                current = node;
            }
        }
    }
    private List<Integer> visit(TreeNode current) {
        List<Integer> result = new ArrayList<Integer>();
        if (current != null) {
            result.add(current.val);
            if (current.left != null) {
                result.addAll(visit(current.left));
            }
            if (current.right != null) {
                result.addAll(visit(current.right));
            }
        }
        return result;
    }
}
