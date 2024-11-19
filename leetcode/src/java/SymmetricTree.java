import java.util.ArrayList;
import java.util.List;

public class SymmetricTree extends BaseTreeNode {
    public static void main(String[] args) {
        SymmetricTree instance = new SymmetricTree();
        System.out.println(instance.isSymmetric(generateTreeNode(new Integer[]{1,2,2,3,4,4,3})));
        System.out.println(instance.isSymmetric(generateTreeNode(new Integer[]{1,2,2,null,3,null,3})));
    }
    public boolean isSymmetric(TreeNode root) {
        boolean result = false;
        if (root.left == null && root.right == null) {
            result = true;
        } else {
            List<TreeNode> list = new ArrayList<TreeNode>();
            list.add(root.left);
            list.add(root.right);
            return check(list);
        }
        return result;
    }
    public boolean check(List<TreeNode> list) {
        boolean result = true;
        if (list.size() % 2 == 0) {
            int size = list.size();
            for (int i = 0; i < size / 2; i++) {
                if ((list.get(i) == null && list.get(size - 1 - i) != null)
                        || (list.get(i) != null && list.get(size - 1 - i) == null)
                        || (list.get(i) != null && list.get(size - 1 - i) != null && list.get(i).val != list.get(size - 1 - i).val)) {
                    result = false;
                    break;
                }
            }
            if (result) {
                boolean isCheckNeed = false;
                for (TreeNode treeNode : list) {
                    if (treeNode != null) {
                        isCheckNeed = true;
                        break;
                    }
                }
                if (isCheckNeed) {
                    List<TreeNode> nextList = new ArrayList<TreeNode>();
                    for (TreeNode treeNode : list) {
                        if (treeNode != null) {
                            nextList.add(treeNode.left);
                            nextList.add(treeNode.right);
                        } else {
                            nextList.add(null);
                            nextList.add(null);
                        }
                    }
                    result = check(nextList);
                }
            }
        }
        return result;
    }
}
