import java.util.ArrayList;
import java.util.List;

public class MaxDepthOfBinaryTree extends BaseTreeNode {
    public static void main(String[] args) {
        MaxDepthOfBinaryTree instance = new MaxDepthOfBinaryTree();
        System.out.println(instance.maxDepth(generateTreeNode(new Integer[]{3,9,20,null,null,15,7})));
        System.out.println(instance.maxDepth(generateTreeNode(new Integer[]{1,null,2})));
        System.out.println(instance.maxDepth(generateTreeNode(new Integer[]{1})));
        System.out.println(instance.maxDepth(generateTreeNode(new Integer[]{})));
    }
    public int maxDepth(TreeNode root) {
        int result = 0;
        List<TreeNode> list = new ArrayList<TreeNode>();
        if (root != null) {
            list.add(root);
            do {
                result++;
                list = travelNext(list);
            } while (!list.isEmpty());
        }
        return result;
    }
    private List<TreeNode> travelNext(List<TreeNode> nodeList) {
        List<TreeNode> result = new ArrayList<TreeNode>();
        for (TreeNode node : nodeList) {
            if (node.left != null) {
                result.add(node.left);
            }
            if (node.right != null) {
                result.add(node.right);
            }
        }
        return result;
    }
}
