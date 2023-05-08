from typing import Optional


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        def reverse(node: ListNode, end: ListNode):
            pre = None
            while node != end:
                tmp = node.next
                node.next = pre
                pre = node
                node = tmp
            return pre

        a = b = head
        for i in range(k):
            if not b:
                return head
            b = b.next
        newly = reverse(a, b)
        a.next = self.reverseKGroup(b, k)
        return newly

# leetcode submit region end(Prohibit modification and deletion)
