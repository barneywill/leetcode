from typing import Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class PalindromeLinkedList:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        ls = []
        while head:
            ls.append(head.val)
            head = head.next
        while True:
            if len(ls) <= 1:
                return True
            if ls.pop(0) != ls.pop():
                return False