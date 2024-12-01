from typing import Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class IntersectionOfTwoLinkedLists:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        result = None
        ls = []
        while headA is not None:
            ls.append(headA)
            headA = headA.next
        size = len(ls)
        while headB is not None:
            if headB in ls:
                result = headB
                break
            else:
                headB = headB.next
        return result