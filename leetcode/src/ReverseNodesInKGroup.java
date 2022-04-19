public class ReverseNodesInKGroup extends BaseListNode {
    public static void main(String[] args) {
        ReverseNodesInKGroup instance = new ReverseNodesInKGroup();
        print(instance.reverseKGroup(generate(new int[]{1,2,3,4}), 2));
        print(instance.reverseKGroup(generate(new int[]{1,2,3,4,5}), 2));
        print(instance.reverseKGroup(generate(new int[]{}), 2));
        print(instance.reverseKGroup(generate(new int[]{1}), 2));
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode result = head;
        if (k > 1) {
            ListNode stepNode = null;
            ListNode[] list = new ListNode[k];
            int steps = 0;
            ListNode current = head;
            while (current != null) {
                list[k - steps - 1] = current;
                if (steps == k - 1) {
                    if (stepNode == null) {
                        result = current;
                    } else {
                        stepNode.next = current;
                    }
                    list[k - 1].next = list[0].next;
                    for (int i = 0; i < k - 1; i++) {
                        list[i].next = list[i + 1];
                    }
                    stepNode = list[k - 1];
                    current = stepNode;
                    steps = 0;
                } else {
                    steps++;
                }
                current = current.next;
            }
        }
        return result;
    }
    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode result = head;
        if (k > 1) {
            ListNode[] list = new ListNode[k + 1];
            list[0] = head;
            int steps = 0;
            ListNode tmp = null;
            while (list[0] != null) {
                if (steps == k - 1) {
                    if (list[k] == null) {
                        result = list[0];
                    } else {
                        list[k].next = list[0];
                    }
                    list[k - 1].next = list[0].next;
                    for (int i = 0; i < k - 1; i++) {
                        list[i].next = list[i + 1];
                    }

                    for (int i = 0; i <= k; i++) {
                        if (i < k - i - 1) {
                            tmp = list[i];
                            list[i] = list[k - i - 1];
                            list[k - i - 1] = tmp;
                        } else {
                            break;
                        }
                    }
                    steps = 0;
                } else {
                    steps++;
                }
                for (int i = k; i > 0; i--) {
                    list[i] = list[i - 1];
                }
                list[0] = list[0].next;
            }
        }
        return result;
    }
}
