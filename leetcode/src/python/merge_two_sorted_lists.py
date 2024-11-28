# Definition for singly-linked list.
from typing import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class MergeTwoSortedLists:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        if list1 is None:
            return list2
        elif list2 is None:
            return list1
        else:
            result = None
            cursor = None
            while list1 is not None or list2 is not None:
                if list1 is None:
                    cursor.next = list2
                    break
                elif list2 is None:
                    cursor.next = list1
                    break
                else:
                    tmp = ListNode()
                    if list1.val < list2.val:
                        tmp.val = list1.val
                        list1 = list1.next
                    else:
                        tmp.val = list2.val
                        list2 = list2.next
                    if result is None:
                        result = tmp
                        cursor = result
                    else:
                        cursor.next = tmp
                        cursor = cursor.next
            return result

if __name__ == '__main__':
    instance = MergeTwoSortedLists()
    list1 = ListNode(1, ListNode(3, ListNode(5)))
    list2 = ListNode(2, ListNode(4, ListNode(6)))
    list3 = instance.mergeTwoLists(list1, list2)
    while list3 != None:
        print(list3.val)
        list3 = list3.next