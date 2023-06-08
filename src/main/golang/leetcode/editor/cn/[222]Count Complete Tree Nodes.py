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
    def exist(self, root, level, k):
        bits = 1 << (level - 1)
        node = root
        while node and bits > 0:
            if bits & k:
                node = node.right
            else:
                node = node.left
            bits >>= 1
        return node is not None

    def countNodes(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        level = 0
        node = root
        while node.left:
            node = node.left
            level += 1
        l, r = 2 ** level, 2 ** (level + 1) - 1
        while l < r:
            mid = (l + r + 1) >> 1
            if self.exist(root, level, mid):
                l = mid
            else:
                r = mid - 1
        return l
# leetcode submit region end(Prohibit modification and deletion)
