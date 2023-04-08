public class SumRootToLeafNumbers extends BaseTreeNode {
    public static void main(String[] args) {
        SumRootToLeafNumbers instance = new SumRootToLeafNumbers();
        System.out.println(instance.sumNumbers(generateTreeNode(new Integer[]{1, 2, 3})));
        System.out.println(instance.sumNumbers(generateTreeNode(new Integer[]{4, 9, 0, 5, 1})));

    }
    public int sumNumbers(TreeNode root) {
        int result = 0;
        result = visit(result, root, null);
        return result;
    }
    private int visit(int sum, TreeNode node, TreeNode parent) {
        node.val = (parent == null ? 0 : parent.val) * 10 + node.val;
        if (node.left == null && node.right == null) {
            sum += node.val;
        } else {
            if (node.left != null) {
                sum = visit(sum, node.left, node);
            }
            if (node.right != null) {
                sum = visit(sum, node.right, node);
            }
        }
        return sum;
    }
}
