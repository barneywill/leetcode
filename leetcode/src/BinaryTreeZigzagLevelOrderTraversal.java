import java.util.ArrayList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal extends BaseTreeNode {
    public static void main(String[] args) {
        BinaryTreeZigzagLevelOrderTraversal instance = new BinaryTreeZigzagLevelOrderTraversal();
        System.out.println(instance.zigzagLevelOrder(generateTreeNode(new Integer[]{3,9,20,null,null,15,7})));
        System.out.println(instance.zigzagLevelOrder(generateTreeNode(new Integer[]{1,2,3,4,null,null,5})));
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root != null) {
            List<TreeNode> nodeList = new ArrayList<TreeNode>();
            nodeList.add(root);
            travel(result, nodeList, true);
        }
        return result;
    }
    private void travel(List<List<Integer>> result, List<TreeNode> nodeList, boolean flag) {
        List<Integer> list = new ArrayList<Integer>();
        List<TreeNode> nextNodeList = new ArrayList<TreeNode>();
        if (flag) {
            for (TreeNode node : nodeList) {
                list.add(node.val);
            }
        } else {
            for (int i = nodeList.size() - 1; i >= 0; i--) {
                TreeNode node = nodeList.get(i);
                list.add(node.val);
            }
        }
        for (TreeNode node : nodeList) {
            if (node.left != null) {
                nextNodeList.add(node.left);
            }
            if (node.right != null) {
                nextNodeList.add(node.right);
            }
        }
        result.add(list);
        if (!nextNodeList.isEmpty()) {
            travel(result, nextNodeList, !flag);
        }
    }
}
