import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalII extends BaseTreeNode {
    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversalII instance = new BinaryTreeLevelOrderTraversalII();
        System.out.println(instance.levelOrderBottom(generateTreeNode(new Integer[]{3,9,20,null,null,15,7})));
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
        result.add(0, list);
        if (!nextNodeList.isEmpty()) {
            travel(result, nextNodeList);
        }
    }
}
