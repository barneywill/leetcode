import java.util.ArrayList;
import java.util.List;

public class RecoverBinarySearchTree extends BaseTreeNode {
    public static void main(String[] args) {
        RecoverBinarySearchTree instance = new RecoverBinarySearchTree();
        TreeNode root = generate(new Integer[]{3,1,4,null,null,2});
        printTreeNode(root);
        instance.recoverTree(root);
        printTreeNode(root);

        root = generate(new Integer[]{2, 3, 1});
        printTreeNode(root);
        instance.recoverTree(root);
        printTreeNode(root);

        //[3,null,2,null,1]
        root = generate(new Integer[]{3,null,2,null,1});
        printTreeNode(root);
        instance.recoverTree(root);
        printTreeNode(root);
    }
    public void recoverTree(TreeNode root) {
        // List<TreeNode> list = new ArrayList<TreeNode>();
        // list.add(root);
        // while (true) {
        //     if (list.isEmpty()) {
        //         break;
        //     }
        //     TreeNode current = list.remove(0);
        //     if (current.left != null) {
        //         if (current.left.val > current.val) {
        //             int tmp = current.val;
        //             current.val = current.left.val;
        //             current.left.val = tmp;
        //             break;
        //         } else {
        //             list.add(current.left);
        //         }
        //     }
        //     if (current.right != null) {
        //         if (current.right.val < current.val) {
        //             int tmp = current.val;
        //             current.val = current.right.val;
        //             current.right.val = tmp;
        //             break;
        //         } else {
        //             list.add(current.right);
        //         }
        //     }
        // }
        List<TreeNode[]> list = new ArrayList<TreeNode[]>();
        findMistake(root, null, null, list);
        if (list.size() == 1) {
            Integer tmp = list.get(0)[0].val;
            list.get(0)[0].val = list.get(0)[1].val;
            list.get(0)[1].val = tmp;
        } else if (list.size() == 2) {
            Integer tmp = list.get(0)[0].val;
            list.get(0)[0].val = list.get(1)[0].val;
            list.get(1)[0].val = tmp;
        }
    }
    private void findMistake(TreeNode treeNode, TreeNode ground, TreeNode ceiling, List<TreeNode[]> list) {
        if (treeNode != null) {
            if (ground != null && treeNode.val < ground.val) {
                list.add(new TreeNode[]{treeNode, ground});
            } else {
                findMistake(treeNode.left, ground, treeNode, list);
            }
            if (ceiling != null && treeNode.val > ceiling.val) {
                list.add(new TreeNode[]{treeNode, ceiling});
            } else {
                findMistake(treeNode.right, treeNode, ceiling, list);
            }
        }
    }
}
