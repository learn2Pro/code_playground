from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left: Optional[TreeNode] = left
        self.right: Optional[TreeNode] = right


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """

        def dfs(node):
            if not node:
                return None
            if not node.left and not node.right:
                return node
            left = dfs(node.left)
            right = dfs(node.right)
            if left is not None:
                node.right, left.right = node.left, node.right
                node.left = None
            return right if right is not None else left

        dfs(root)
        return root


# leetcode submit region end(Prohibit modification and deletion)
