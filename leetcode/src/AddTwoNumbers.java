import java.util.ArrayList;
import java.util.List;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        List<Integer> resultList = new ArrayList<Integer>();
        ListNode current1 = l1;
        ListNode current2 = l2;
        int add = 0;
        while ((current1 != null) || (current2 != null)) {
            int item1 = current1 == null ? 0 : current1.val;
            int item2 = current2 == null ? 0 : current2.val;
            int sum = item1 + item2 + add;
            resultList.add(sum % 10);
            add = sum / 10;
            if (current1 != null) current1 = current1.next;
            if (current2 != null) current2 = current2.next;
        }
        if (add > 0) {
            resultList.add(add);
        }
        for (int i = resultList.size() - 1; i >= 0; i--) {
            if (result == null) {
                result = new ListNode(resultList.get(i));
            } else {
                result = new ListNode(resultList.get(i), result);
            }
        }
        return result;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
