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
    def rob(self, root: Optional[TreeNode]) -> int:
        def rob(node):
            if not node:
                return 0, 0
            left, right = rob(node.left), rob(node.right)
            return max(left) + max(right), node.val + left[0] + right[0]
        fst, snd = rob(root)
        return max(fst, snd)
# leetcode submit region end(Prohibit modification and deletion)
