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
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        ans = 0

        def dfs(depth, node):
            nonlocal ans
            if not node:
                ans = max(ans, depth)
                return
            dfs(depth + 1, node.left)
            dfs(depth + 1, node.right)

        dfs(0, root)
        return ans
# leetcode submit region end(Prohibit modification and deletion)
