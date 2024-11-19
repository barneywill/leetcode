public class RotateList extends BaseListNode {
    public static void main(String[] args) {
        RotateList instance = new RotateList();
        ListNode result = instance.rotateRight(generateListNode(new int[]{1,2,3,4,5}), 2);
        while (result != null) {
            System.out.print(result.val + ",");
            result = result.next;
        }
        System.out.println();

        result = instance.rotateRight(generateListNode(new int[]{0,1,2}), 4);
        while (result != null) {
            System.out.print(result.val + ",");
            result = result.next;
        }
        System.out.println();
    }
    public ListNode rotateRight(ListNode head, int k) {
        ListNode result = head;
        if (head != null && k > 0) {
            int length = 1;
            ListNode newHead = head;
            ListNode newTail = null;
            ListNode tail = null;
            while (newHead.next != null) {
                length++;
                newTail = newHead;
                newHead = newHead.next;
            }
            tail = newHead;
            if (length > 1 && k % length > 0) {
                if (k % length > 1) {
                    int target = length - (k % length);
                    int current = 0;
                    newHead = head;
                    while (current++ < target) {
                        newTail = newHead;
                        newHead = newHead.next;
                    }
                }
                result = newHead;
                tail.next = head;
                newTail.next = null;
            }
        }
        return result;
    }
}
