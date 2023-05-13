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
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        ans = float('-inf')

        def dfs(node: TreeNode):
            if not node:
                return 0
            nonlocal ans
            left, right = dfs(node.left), dfs(node.right)
            ans = max(ans, node.val + left + right)
            return max(0, node.val + max(left, right))
        dfs(root)
        return ans
# leetcode submit region end(Prohibit modification and deletion)
