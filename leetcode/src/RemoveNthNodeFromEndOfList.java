public class RemoveNthNodeFromEndOfList extends BaseListNode {
    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList instance = new RemoveNthNodeFromEndOfList();
        print(instance.removeNthFromEnd(generate(new int[]{1,2,3,4,5}), 2));
        print(instance.removeNthFromEnd(generate(new int[]{1}), 1));
        print(instance.removeNthFromEnd(generate(new int[]{1,2}), 1));
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
}