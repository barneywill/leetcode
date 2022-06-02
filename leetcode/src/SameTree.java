public class SameTree extends BaseTreeNode {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return getSign(p, "").toString().equals(getSign(q, "").toString());
    }
    private StringBuffer getSign(TreeNode tn, String prefix) {
        StringBuffer result = new StringBuffer(prefix);
        return tn == null ? result : result.append(tn.val).append(getSign(tn.left, "L")).append(getSign(tn.right, "R"));
    }
}
