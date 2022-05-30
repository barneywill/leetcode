public class RemoveDuplicateFromSortedList extends BaseListNode {
    public static void main(String[] args) {
        RemoveDuplicateFromSortedList instance = new RemoveDuplicateFromSortedList();
        print(instance.deleteDuplicates(generate(new int[]{1,2,3,3,4,4,5})));
        print(instance.deleteDuplicates(generate(new int[]{1,1,1,2,3})));
        print(instance.deleteDuplicates(generate(new int[]{1,1,1})));
        print(instance.deleteDuplicates(generate(new int[]{1,2,2})));
        print(instance.deleteDuplicates(generate(new int[]{1})));
    }
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null) {
            while (current.next != null && current.val == current.next.val) {
                current.next = current.next.next;
            }
            current = current.next;
        }
        return head;
    }
}
