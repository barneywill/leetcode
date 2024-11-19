public class ReverseLinkedList2 extends BaseListNode {
    public static void main(String[] args) {
        ReverseLinkedList2 instance = new ReverseLinkedList2();
        print(instance.reverseBetween(generateListNode(new int[]{1, 2, 3, 4, 5}), 2, 4));
        print(instance.reverseBetween(generateListNode(new int[]{1, 2, 3, 4, 5}), 1, 5));
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode current = head;
        ListNode previous = null;
        ListNode newFirst = null;
        ListNode newLast = null;
        int index = 1;
        while (current != null) {
            ListNode next = current.next;
            if (index == left - 1) {
                previous = current;
            } else if (index == left) {
                newFirst = current;
                newLast = current;
            } else if (index > left && index < right) {
                current.next = newFirst;
                newFirst = current;
            } else if (index == right) {
                current.next = newFirst;
                newFirst = current;
                if (previous != null) {
                    previous.next = newFirst;
                }
                newLast.next = next;
                break;
            }
            index++;
            current = next;
        }
        return previous == null ? newFirst : head;
    }
}
