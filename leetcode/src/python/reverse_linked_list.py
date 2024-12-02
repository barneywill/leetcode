from typing import Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class ReverseLinkedList:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        result = None
        while head is not None:
            result = ListNode(head.val, result)
            head = head.next
        return result