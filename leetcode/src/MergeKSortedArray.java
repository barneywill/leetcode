public class MergeKSortedArray extends BaseListNode {
    public static void main(String[] args) {
        MergeKSortedArray instance = new MergeKSortedArray();
        print(instance.mergeKLists(new ListNode[]{generate(new int[]{1,4,5}), generate(new int[]{1,3,4}), generate(new int[]{2,6})}));
    }
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = null;
        if (lists.length > 0) {
            int[] arr = new int[20001];
            for (ListNode list : lists) {
                ListNode current = list;
                while (current != null) {
                    arr[current.val + 10001]++;
                    current = current.next;
                }
            }
//            for (int i = 0; i < arr.length; i++) {
//                if (arr[i] > 0) {
//                    System.out.println(i + " : " + arr[i]);
//                }
//            }
            for (int i = arr.length - 1; i >= 0; i--) {
                if (arr[i] > 0) {
                    for (int j = 0; j < arr[i]; j++) {
                        if (result == null) {
                            result = new ListNode(i - 10001);
                        } else {
                            result = new ListNode(i - 10001, result);
                        }
                    }
                }
            }
        }
        return result;
    }

}
