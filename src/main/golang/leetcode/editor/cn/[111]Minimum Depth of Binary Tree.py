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
    def minDepth(self, root: Optional[TreeNode]) -> int:
        ans = 0

        def dfs(depth, node):
            nonlocal ans
            if not node:
                return
            if not node.left and not node.right:
                ans = min(ans, depth + 1) if ans else depth + 1
                return
            dfs(depth + 1, node.left)
            dfs(depth + 1, node.right)

        dfs(0, root)
        return ans
# leetcode submit region end(Prohibit modification and deletion)
