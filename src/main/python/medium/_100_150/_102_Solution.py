# 102. Binary Tree Level Order Traversal
from typing import List

from src.main.python.TreeNode import TreeNode


class _102_Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if root is None: return []
        queue = []
        ans = []
        queue.append(root)
        while queue:
            size = len(queue)
            partial = []
            for i in range(size):
                current = queue.pop(0)
                if current.left: queue.append(current.left)
                if current.right: queue.append(current.right)
                partial.append(current.val)
            ans.append(partial)
        return ans
