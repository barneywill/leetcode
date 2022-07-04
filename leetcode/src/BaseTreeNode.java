import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseTreeNode {
     static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    static TreeNode generate(Integer[] nums) {
         TreeNode root = null;
         if (nums.length > 0) {
             List<Integer> numsList = new ArrayList<Integer>(Arrays.asList(nums));
             root = new TreeNode(numsList.remove(0));
             List<TreeNode> queue = new ArrayList<TreeNode>();
             queue.add(root);
             while (!queue.isEmpty()) {
                 TreeNode current = queue.remove(0);
                 if (current == null) {
                     continue;
                 }
                 if (!numsList.isEmpty()) {
                     Integer left = numsList.remove(0);
                     if (left != null) {
                         current.left = new TreeNode(left);
                         queue.add(current.left);
                     } else {
                         queue.add(null);
                     }
                 }
                 if (!numsList.isEmpty()) {
                     Integer right = numsList.remove(0);
                     if (right != null) {
                         current.right = new TreeNode(right);
                         queue.add(current.right);
                     } else {
                         queue.add(null);
                     }
                 }
             }
         }
         return root;
    }
    static void printTreeNode(TreeNode treeNode) {
         StringBuffer buf = new StringBuffer();
         List<TreeNode> queue = new ArrayList<TreeNode>();
         queue.add(treeNode);
         while (!queue.isEmpty()) {
             TreeNode current = queue.remove(0);
             if (current == null) {
                 buf.append("null, ");
             } else {
                 buf.append(current.val).append(", ");
                 queue.add(current.left);
                 queue.add(current.right);
             }
         }
         System.out.println(buf.toString());
    }
}
