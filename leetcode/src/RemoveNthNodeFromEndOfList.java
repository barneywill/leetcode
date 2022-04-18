public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList instance = new RemoveNthNodeFromEndOfList();
        print(instance.removeNthFromEnd(generate(new int[]{1,2,3,4,5}), 2));
        print(instance.removeNthFromEnd(generate(new int[]{1}), 1));
        print(instance.removeNthFromEnd(generate(new int[]{1,2}), 1));
    }
    private static void print(ListNode node) {
        if (node != null) {
            while (node != null) {
                System.out.print(node.val);
                node = node.next;
            }
        }
        System.out.println();
    }
    private static ListNode generate(int[] nums) {
        ListNode result = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            result = new ListNode(nums[i], result);
        }
        return result;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode nthNode = null;
        ListNode previousNode = null;
        ListNode current = head;
        int i = 1;
        while (current != null) {
            if (i == n) {
                nthNode = head;
            }
            i++;
            current = current.next;
            if (current != null && nthNode != null) {
                previousNode = nthNode;
                nthNode = nthNode.next;
            }
        }
        if (previousNode == null) {
            if (nthNode.next != null) {
                return nthNode.next;
            } else {
                return null;
            }
        } else {
            if (nthNode.next != null) {
                previousNode.next = nthNode.next;
            } else {
                previousNode.next = null;
            }
            return head;
        }
    }
    static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */