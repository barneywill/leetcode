public class BaseListNode {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    static ListNode generate(int[] nums) {
        ListNode result = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            result = new ListNode(nums[i], result);
        }
        return result;
    }
    static void print(ListNode node) {
        if (node != null) {
            while (node != null) {
                System.out.print(node.val);
                node = node.next;
            }
        }
        System.out.println();
    }
}
