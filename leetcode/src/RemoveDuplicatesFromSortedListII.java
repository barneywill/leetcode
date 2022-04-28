public class RemoveDuplicatesFromSortedListII extends BaseListNode {
    //TODO:
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedListII instance = new RemoveDuplicatesFromSortedListII();
        print(instance.deleteDuplicates(generate(new int[]{1,2,3,3,4,4,5})));
        print(instance.deleteDuplicates(generate(new int[]{1,1,1,2,3})));
    }
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        ListNode previous = null;
        ListNode newHead = null;
        ListNode tail = null;
        while (current != null) {
            if (previous == null) {
                previous = current;
                current = current.next;
            } else if (current.val == previous.val) {
                current = current.next;
                previous.next = current;
            } else {
                previous = current;
                current = current.next;
            }
        }
        return newHead;
    }
}
