from typing import Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class RemoveDuplicatesFromSortedList:
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if head is not None:
            current = head
            while current.next is not None:
                n = current.next
                if current.val == n.val:
                    current.next = n.next
                else:
                    current = n
        return head