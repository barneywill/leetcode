public class RemoveDuplicatesFromSortedListII extends BaseListNode {
    //TODO:
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedListII instance = new RemoveDuplicatesFromSortedListII();
        print(instance.deleteDuplicates(generateListNode(new int[]{1,2,3,3,4,4,5})));
        print(instance.deleteDuplicates(generateListNode(new int[]{1,1,1,2,3})));
        print(instance.deleteDuplicates(generateListNode(new int[]{1,1,1})));
        print(instance.deleteDuplicates(generateListNode(new int[]{1,2,2})));
        print(instance.deleteDuplicates(generateListNode(new int[]{1})));
    }
    public ListNode deleteDuplicates(ListNode head) {
        //newHead: when newHead == null and previous != current and previous != lastDuplicateValue then newHead = previous
        //newTail: when previous != current and previous != lastDuplicateValue then newTail = previous, last previous, cross newTail
        //previous -> current: when previous == current set the lastDuplicateValue
        //lastDuplicateValue

        ListNode current = head;
        ListNode previous = null;
        ListNode newHead = null;
        ListNode newTail = null;
        int duplicateValue = -200;
        while (current != null) {
            if (previous == null) {
            } else if (current.val == previous.val) {
                duplicateValue = current.val;
            } else {
                if (duplicateValue != previous.val) {
                    if (newHead == null) {
                        newHead = previous;
                        newTail = previous;
                    } else {
                        newTail.next = previous;
                        newTail = newTail.next;
                    }
                }
            }
            previous = current;
            current = current.next;
        }
        if (previous != null && duplicateValue != previous.val) {
            if (newHead == null) {
                newHead = previous;
                newTail = previous;
            } else {
                newTail.next = previous;
                newTail = newTail.next;
            }
        }
        if (newTail != null) {
            newTail.next = null;
        }
        return newHead;
    }
}
