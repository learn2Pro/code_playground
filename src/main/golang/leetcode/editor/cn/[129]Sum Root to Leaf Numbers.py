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
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        ans = 0

        def dfs(node: TreeNode, path: int):
            if not node:
                return
            nonlocal ans
            path = path * 10 + node.val
            if not node.left and not node.right:
                ans += path
            dfs(node.left, path)
            dfs(node.right, path)
        dfs(root, 0)
        return ans

# leetcode submit region end(Prohibit modification and deletion)
