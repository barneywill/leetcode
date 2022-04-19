public class SwapNodesInPairs extends BaseListNode {
    public static void main(String[] args) {
        SwapNodesInPairs instance = new SwapNodesInPairs();
        print(instance.swapPairs(generate(new int[]{1,2,3,4})));
        print(instance.swapPairs(generate(new int[]{1,2,3,4,5})));
        print(instance.swapPairs(generate(new int[]{})));
        print(instance.swapPairs(generate(new int[]{1})));
    }
    public ListNode swapPairs(ListNode head) {
        ListNode result = head;
        ListNode firstNode = head;
        ListNode secondNode = null;
        ListNode thirdNode = null;
        ListNode tmp = null;
        int steps = 0;
        while (firstNode != null) {
            if (steps == 1) {
                if (thirdNode == null) {
                    result = firstNode;
                } else {
                    thirdNode.next = firstNode;
                }
                secondNode.next = firstNode.next;
                firstNode.next = secondNode;

                tmp = firstNode;
                firstNode = secondNode;
                secondNode = tmp;

                steps = 0;
            } else {
                steps++;
            }
            thirdNode = secondNode;
            secondNode = firstNode;
            firstNode = firstNode.next;
        }
        return result;
    }
}
