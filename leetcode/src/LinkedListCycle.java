import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle extends BaseListNode {
    public static void main(String[] args) {
        LinkedListCycle instance = new LinkedListCycle();
        System.out.println(instance.hasCycle(generateListNode(new int[]{3, 2, 0, -4})));
    }
    public boolean hasCycle(ListNode head) {
        boolean result = false;
        Set<ListNode> set = new HashSet<ListNode>();
        if (head != null) {
            set.add(head);
            ListNode temp = head;
            while (temp.next != null) {
                if (set.contains(temp.next)) {
                    result = true;
                    break;
                } else {
                    set.add(temp.next);
                    temp = temp.next;
                }
            }
        }
        return result;
    }
}
