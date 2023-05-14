from typing import Optional


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverse(self, node):
        if not node or not node.next:
            return node
        pre, curr = None, node
        while curr:
            curr.next, pre, curr = pre, curr, curr.next
        return pre

    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if not head or not head.next or not head.next.next:
            return
        slow = fast = head
        while fast and fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
        new_head = slow.next
        slow.next = None
        new_head = self.reverse(new_head)
        while new_head:
            tmp = new_head.next
            new_head.next = head.next
            head.next = new_head
            head = new_head.next
            new_head = tmp

# leetcode submit region end(Prohibit modification and deletion)
