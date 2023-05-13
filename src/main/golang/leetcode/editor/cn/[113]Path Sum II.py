from typing import Optional, List


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
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        ans = []

        def dfs(node, path, curr):
            if node is None:
                return
            if node.left is None and node.right is None:
                if node.val + curr == targetSum:
                    ans.append(path + [node.val])
                return
            dfs(node.left, path + [node.val], curr + node.val)
            dfs(node.right, path + [node.val], curr + node.val)

        dfs(root, [], 0)
        return ans
# leetcode submit region end(Prohibit modification and deletion)
