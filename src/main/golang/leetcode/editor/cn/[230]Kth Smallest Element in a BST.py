from typing import Optional
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        if root is None:
            return 0
        stack = []
        node = root
        while node is not None:
            stack.append(node)
            node = node.left
        while len(stack) > 0:
            node = stack.pop()
            k -= 1
            if k == 0:
                return node.val
            node = node.right
            while node is not None:
                stack.append(node)
                node = node.left
        return 0
# leetcode submit region end(Prohibit modification and deletion)
