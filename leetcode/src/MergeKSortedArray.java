public class MergeKSortedArray extends BaseListNode {
    public static void main(String[] args) {
        MergeKSortedArray instance = new MergeKSortedArray();
        print(instance.mergeKLists(new ListNode[]{generateListNode(new int[]{1,4,5}), generateListNode(new int[]{1,3,4}), generateListNode(new int[]{2,6})}));
    }
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = null;
        if (lists.length > 0) {
            int min = 10000;
            int max = -10000;
            for (ListNode list : lists) {
                if (list != null && min > list.val) {
                    min = list.val;
                }
            }
            int[] arr = new int[10001 - min];
            for (ListNode list : lists) {
                ListNode current = list;
                while (current != null) {
                    arr[current.val - min]++;
                    if (current.val > max) {
                        max = current.val;
                    }
                    current = current.next;
                }
            }
//            for (int i = 0; i < arr.length; i++) {
//                if (arr[i] > 0) {
//                    System.out.println(i + " : " + arr[i]);
//                }
//            }
            for (int i = max - min; i >= 0; i--) {
                if (arr[i] > 0) {
                    for (int j = 0; j < arr[i]; j++) {
                        if (result == null) {
                            result = new ListNode(i + min);
                        } else {
                            result = new ListNode(i + min, result);
                        }
                    }
                }
            }
        }
        return result;
    }

}
