public class PartitionList extends BaseListNode {
    public static void main(String[] args) {
        PartitionList instance = new PartitionList();
        print(instance.partition(generate(new int[]{1,4,3,2,5,2}), 3));
        print(instance.partition(generate(new int[]{2,1}), 2));
        print(instance.partition(generate(new int[]{1,1}), 2));
    }
    public ListNode partition(ListNode head, int x) {
        //firstLess
        //lastLess
        //firstMore
        //lastMore
        //current
        ListNode firstLess = null;
        ListNode lastLess = null;
        ListNode firstMore = null;
        ListNode lastMore = null;
        ListNode current = head;
        ListNode previous = null;
        while (current != null) {
            previous = current;
            current = current.next;
            if (previous.val < x) {
                if (firstLess == null) {
                    firstLess = previous;
                    lastLess = previous;
                    if (firstMore != null) {
                        lastLess.next = firstMore;
                    }
                } else {
                    lastLess.next = previous;
                    lastLess = previous;
                    lastLess.next = firstMore;
                }
            } else {
                if (firstMore == null) {
                    firstMore = previous;
                    lastMore = previous;
                    if (lastLess != null) {
                        lastLess.next = firstMore;
                    }
                } else {
                    lastMore.next = previous;
                    lastMore = previous;
                }
            }
        }
        if (lastMore != null) {
            lastMore.next = null;
        }
        return firstLess == null ? firstMore : firstLess;
    }
}
