from typing import Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def removeElements(self, head: Optional[ListNode], val: int) -> Optional[ListNode]:
        result = None
        last = None
        while head is not None:
            if head.val != val:
                last = head
                if result is None:
                    result = head
            else:
                if last is not None:
                    last.next = head.next
            head = head.next
        return result