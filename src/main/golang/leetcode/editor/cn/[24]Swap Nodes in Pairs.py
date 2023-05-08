from typing import Optional


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    # def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
    #     if not head: return head
    #     if not head.next: return head
    #     pre, cur = head, head.next
    #     pre.next = self.swapPairs(head.next.next)
    #     cur.next = pre
    #     return cur
    def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode(-1)
        dummy.next = head
        curr = dummy
        while curr.next and curr.next.next:
            n1, n2 = curr.next, curr.next.next
            curr.next = n2
            n1.next = n2.next
            n2.next = n1
            curr = n1
        return dummy.next
# leetcode submit region end(Prohibit modification and deletion)
