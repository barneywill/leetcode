import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal extends BaseTreeNode {
    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal instance = new BinaryTreeLevelOrderTraversal();
        System.out.println(instance.levelOrder(generateTreeNode(new Integer[]{3,9,20,null,null,15,7})));
        System.out.println(instance.levelOrder(generateTreeNode(new Integer[]{3})));
        System.out.println(instance.levelOrder(generateTreeNode(new Integer[]{})));
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root != null) {
            List<TreeNode> nodeList = new ArrayList<TreeNode>();
            nodeList.add(root);
            travel(result, nodeList);
        }
        return result;
    }
    private void travel(List<List<Integer>> result, List<TreeNode> nodeList) {
        List<Integer> list = new ArrayList<Integer>();
        List<TreeNode> nextNodeList = new ArrayList<TreeNode>();
        for (TreeNode node : nodeList) {
            list.add(node.val);
            if (node.left != null) {
                nextNodeList.add(node.left);
            }
            if (node.right != null) {
                nextNodeList.add(node.right);
            }
        }
        result.add(list);
        if (!nextNodeList.isEmpty()) {
            travel(result, nextNodeList);
        }
    }
}
