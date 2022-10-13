import java.util.ArrayList;
import java.util.List;

public class BalancedBinaryTree extends BaseTreeNode {
    public static void main(String[] args) {
        BalancedBinaryTree instance = new BalancedBinaryTree();
        System.out.println(instance.isBalanced(generateTreeNode(new Integer[]{3,9,20,null,null,15,7})));
        System.out.println(instance.isBalanced(generateTreeNode(new Integer[]{1,2,2,3,3,null,null,4,4})));
        System.out.println(instance.isBalanced(generateTreeNode(new Integer[]{1,2,3,4,5,6,null,8})));
        System.out.println(instance.isBalanced(generateTreeNode(new Integer[]{})));
    }
    public boolean isBalanced(TreeNode root) {
        try {
            visit(root);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    private int visit(TreeNode node) throws Exception {
        int depth = 0;
        if (node != null) {
            if (node.left == null && node.right == null) {
                depth = 1;
            } else {
                int leftDepth = 0;
                int rightDepth = 0;
                if (node.left != null) {
                    leftDepth = visit(node.left);
                }
                if (node.right != null) {
                    rightDepth = visit(node.right);
                }
                if (Math.abs(leftDepth - rightDepth) > 1) {
                    throw new Exception("not balanced : " + node.val);
                } else {
                    depth = Math.max(leftDepth, rightDepth) + 1;
                }
            }
        }
        return depth;
    }
//    public boolean isBalanced(TreeNode root) {
//        List<TreeNode> list = new ArrayList<TreeNode>();
//        list.add(root);
//        List<TreeNode> last2List = null;
//        List<TreeNode> last1List = null;
//        do {
//            last2List = last1List;
//            last1List = list;
//            list = travel(list);
//        } while (list != null);
//        boolean isLast1ListContainsNull = false;
//        for (TreeNode node : last1List) {
//            if (node == null) {
//                isLast1ListContainsNull = true;
//                break;
//            }
//        }
//        System.out.println("1 : " + isLast1ListContainsNull + ", " + last1List);
//        if (!isLast1ListContainsNull) {
//            return true;
//        } else {
//            boolean isLast2ListContainsNull = false;
//            if (last2List != null) {
//                for (TreeNode node : last2List) {
//                    if (node == null) {
//                        isLast2ListContainsNull = true;
//                        break;
//                    }
//                }
//            }
//            System.out.println("2 : " + isLast2ListContainsNull + ", " + last2List);
//            return !isLast2ListContainsNull;
//        }
//    }
//    private List<TreeNode> travel(List<TreeNode> list) {
//        List<TreeNode> result = new ArrayList<TreeNode>();
//        for (TreeNode node : list) {
//            if (node != null) {
//                result.add(node.left);
//                result.add(node.right);
//            } else {
//                result.add(null);
//                result.add(null);
//            }
//        }
//        boolean isAllNull = true;
//        for (TreeNode node : result) {
//            if (node != null) {
//                isAllNull = false;
//                break;
//            }
//        }
//        return isAllNull ? null : result;
//    }
}
