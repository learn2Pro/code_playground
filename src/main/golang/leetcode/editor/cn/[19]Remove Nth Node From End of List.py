from typing import Optional


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    # def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
    #     def findFromEnd(node: ListNode, k: int):
    #         p1 = node
    #         for i in range(k):
    #             p1 = p1.next
    #         p2 = node
    #         while p1 != None:
    #             p1, p2 = p1.next, p2.next
    #         return p2
    #
    #     dummy = ListNode(-1, head)
    #     n_1 = findFromEnd(dummy, n + 1)
    #     n_1.next = n_1.next.next
    #     return dummy.next
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        dummy = ListNode(-1, head)
        stack = []
        curr = dummy
        while curr != None:
            stack.append(curr)
            curr = curr.next
        for i in range(n):
            stack.pop()
        node = stack[-1]
        node.next = node.next.next
        return dummy.next

# leetcode submit region end(Prohibit modification and deletion)
