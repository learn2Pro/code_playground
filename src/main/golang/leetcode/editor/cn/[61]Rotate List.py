from typing import Optional


# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


# leetcode submit region begin(Prohibit modification and deletion)

class Solution:
    def rotateRight(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if not head: return head
        tail = head
        n = 1
        while tail.next:
            tail = tail.next
            n += 1
        k %= n
        if k == 0: return head
        tail.next = head
        for _ in range(n - k):
            tail = tail.next
        head = tail.next
        tail.next = None
        return head

# leetcode submit region end(Prohibit modification and deletion)
