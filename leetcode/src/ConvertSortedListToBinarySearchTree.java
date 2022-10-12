import java.util.ArrayList;
import java.util.List;

public class ConvertSortedListToBinarySearchTree extends BaseListNode {
    public static void main(String[] args) {
        ConvertSortedListToBinarySearchTree instance = new ConvertSortedListToBinarySearchTree();
        printTreeNode(instance.sortedListToBST(generateListNode(new int[]{-10,-3,0,5,9})));
    }
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<Integer>();
        ListNode current = head;
        do {
            list.add(current.val);
            current = current.next;
        } while (current != null);
        return generateTreeNode(list.toArray(new Integer[0]), 0, list.size() - 1);
    }
    private TreeNode generateTreeNode(Integer[] nums, int start, int end) {
        TreeNode result = null;
        if (start == end) {
            result = new TreeNode(start);
        } else if (start + 1 == end) {
            result = new TreeNode(nums[start], null, new TreeNode(nums[end]));
        } else if (start + 2 == end) {
            result = new TreeNode(nums[start + 1], new TreeNode(nums[start]), new TreeNode(nums[end]));
        } else {
            int middle = nums.length / 2;
            result = new TreeNode(nums[middle], generateTreeNode(nums, start, middle - 1), generateTreeNode(nums, middle + 1, end));
        }
        return result;
    }
}
