from typing import Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class AddTwoNumbers:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        root = None
        current = None
        leftover = 0
        while l1 is not None or l2 is not None:
            sum = leftover
            sum += l1.val if l1 is not None else 0
            sum += l2.val if l2 is not None else 0
            if sum >= 10:
                leftover = 1
                sum = sum - 10
            else:
                leftover = 0
            if root is None:
                root = ListNode(sum)
                current = root
            else:
                current.next = ListNode(sum)
                current = current.next
            l1 = l1.next if l1 is not None else l1
            l2 = l2.next if l2 is not None else l2
        if leftover != 0:
            current.next = ListNode(leftover)
        return root