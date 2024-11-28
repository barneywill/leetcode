from typing import Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class LinkedListCycle:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        node_set = set()
        if head is not None:
            current = head
            while current is not None:
                if current in node_set:
                    return True
                else:
                    node_set.add(current)
                current = current.next
        return False