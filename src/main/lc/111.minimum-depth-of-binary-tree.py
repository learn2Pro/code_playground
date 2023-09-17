#
# @lc app=leetcode id=111 lang=python3
#
# [111] Minimum Depth of Binary Tree
#

# @lc code=start
# Definition for a binary tree node.
from typing import Optional, List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def minDepth(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        if not root.left and not root.right:
            return 1
        if root.left is None:
            return 1+self.minDepth(root.right)
        elif root.right is None:
            return 1+self.minDepth(root.left)
        return 1+min(self.minDepth(root.left), self.minDepth(root.right))

# @lc code=end
