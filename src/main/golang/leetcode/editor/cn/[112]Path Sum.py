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
    def hasPathSum(self, root: Optional[TreeNode], targetSum: int) -> bool:

        def dfs(node, curr):
            if node is None:
                return False
            if node.left is None and node.right is None:
                return curr + node.val == targetSum
            return dfs(node.left, curr + node.val) or dfs(node.right, curr + node.val)

        return dfs(root, 0)
# leetcode submit region end(Prohibit modification and deletion)
