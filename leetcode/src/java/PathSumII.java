import java.util.ArrayList;
import java.util.List;

public class PathSumII extends BaseTreeNode {
    public static void main(String[] args) {
        PathSumII instance = new PathSumII();
        System.out.println(instance.pathSum(generateTreeNode(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,null,1}), 22));
        System.out.println(instance.pathSum(generateTreeNode(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,5,1}), 22));
        System.out.println(instance.pathSum(generateTreeNode(new Integer[]{}), 1));
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        return visit(root, new ArrayList<Integer>(), 0, targetSum);
    }
    private List<List<Integer>> visit(TreeNode node, List<Integer> list, int sum, int targetSum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (node != null) {
            int currentSum = sum + node.val;
            List<Integer> nextList = new ArrayList<Integer>(list);
            nextList.add(node.val);
            if (node.left == null && node.right == null) {
                if (currentSum == targetSum) {
                    result.add(nextList);
                }
            } else {
                if (node.left != null) {
                    List<List<Integer>> leftResult = visit(node.left, nextList, currentSum, targetSum);
                    if (!leftResult.isEmpty()) {
                        result.addAll(leftResult);
                    }
                }
                if (node.right != null) {
                    List<List<Integer>> rightResult = visit(node.right, nextList, currentSum, targetSum);
                    if (!rightResult.isEmpty()) {
                        result.addAll(rightResult);
                    }
                }
            }
        }
        return result;
    }
}
