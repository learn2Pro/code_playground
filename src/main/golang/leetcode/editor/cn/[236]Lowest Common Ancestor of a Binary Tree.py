class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        def dfs(node):
            if not node:
                return False
            left, right = dfs(node.left), dfs(node.right)
            mid = node == p or node == q
            if mid + left + right >= 2:
                self.ans = node
            return mid or left or right

        self.ans = None
        dfs(root)
        return self.ans
# leetcode submit region end(Prohibit modification and deletion)
