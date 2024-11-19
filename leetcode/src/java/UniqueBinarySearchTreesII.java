import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII extends BaseTreeNode {
    public static void main(String[] args) {
        UniqueBinarySearchTreesII instance = new UniqueBinarySearchTreesII();
        List<TreeNode> result = instance.generateTrees(1);
        for (TreeNode treeNode : result) {
            BaseTreeNode.printTreeNode(treeNode);
        }
    }
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }
    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> result = null;
        if (start <= end) {
            result = new ArrayList<TreeNode>();
            if (start == end) {
                result.add(new TreeNode(start));
            } else {
                for (int i = start; i <= end; i++) {
                    List<TreeNode> leftTrees = generateTrees(start, i - 1);
                    List<TreeNode> rightTrees = generateTrees(i + 1, end);
                    if (leftTrees == null) {
                        for (TreeNode rightTree : rightTrees) {
                            result.add(new TreeNode(i, null, rightTree));
                        }
                    } else if (rightTrees == null) {
                        for (TreeNode leftTree : leftTrees) {
                            result.add(new TreeNode(i, leftTree, null));
                        }
                    } else {
                        for (TreeNode leftTree : leftTrees) {
                            for (TreeNode rightTree : rightTrees) {
                                result.add(new TreeNode(i, leftTree, rightTree));
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}
