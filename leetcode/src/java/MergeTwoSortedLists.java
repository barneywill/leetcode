public class MergeTwoSortedLists extends BaseListNode {
    public static void main(String[] args) {

    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = null;
        if (list1 == null) {
            result = list2;
        } else if (list2 == null) {
            result = list1;
        } else {
            ListNode current = null;
            while (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    if (result == null) {
                        current = list1;
                        result = current;
                    } else {
                        current.next = list1;
                        current = list1;
                    }
                    list1 = list1.next;
                } else {
                    if (result == null) {
                        current = list2;
                        result = current;
                    } else {
                        current.next = list2;
                        current = list2;
                    }
                    list2 = list2.next;
                }
            }
            if (list1 == null) {
                current.next = list2;
            } else {
                current.next = list1;
            }
        }
        return result;
    }
}
