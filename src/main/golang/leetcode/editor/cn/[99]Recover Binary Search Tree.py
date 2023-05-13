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
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """

        def inorder(node):
            if not node:
                return
            inorder(node.left)
            if self.pre and self.pre.val > node.val:
                if not self.first:
                    self.first = self.pre
                self.second = node
            self.pre = node
            inorder(node.right)

        self.pre = None
        self.first = None
        self.second = None
        inorder(root)
        self.first.val, self.second.val = self.second.val, self.first.val
# leetcode submit region end(Prohibit modification and deletion)
