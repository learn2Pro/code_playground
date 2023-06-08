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
    def binaryTreePaths(self, root: Optional[TreeNode]) -> List[str]:
        if not root:
            return []
        ans = []

        def dfs(node: TreeNode, path: str):
            if not node.left and not node.right:
                ans.append(path + str(node.val))
                return
            if node.left:
                dfs(node.left, path + str(node.val) + '->')
            if node.right:
                dfs(node.right, path + str(node.val) + '->')

        dfs(root, '')
        return ans
# leetcode submit region end(Prohibit modification and deletion)
