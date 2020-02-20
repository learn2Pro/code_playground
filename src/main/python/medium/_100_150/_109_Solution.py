# 109. Convert Sorted List to Binary Search Tree
from src.main.python.ListNode import ListNode
from src.main.python.TreeNode import TreeNode


class _109_Solution:
    # two pointer
    def sortedListToBST(self, head: ListNode) -> TreeNode:
        def helper(left: ListNode, right: ListNode) -> TreeNode:
            if left == right: return None
            fast = slow = last = left
            while fast != right and fast.next != right:
                fast = fast.next.next
                last = slow
                slow = slow.next
            current = TreeNode(slow.val)
            current.left = helper(left, last)
            current.right = helper(slow.next, right)
            return current

        return helper(head, None)
# array
# def sortedListToBST(self, head: ListNode) -> TreeNode:
#     lst = []
#     while head: lst.append(head.val);head = head.next
#
#     def helper(start: int, end: int) -> TreeNode:
#         if start > end: return None
#         mid = (start + end) >> 1
#         current = TreeNode(lst[mid])
#         current.left = helper(start, mid - 1)
#         current.right = helper(mid + 1, end)
#         return current
#
#     return helper(0, len(lst) - 1)
