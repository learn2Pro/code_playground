# 103. Binary Tree Zigzag Level Order Traversal
from typing import List

from src.main.python.TreeNode import TreeNode

'''
[3,9,20,null,null,15,7]
[1]
[]
[1,2]
[1,2,3,4,null,null,5]
'''


class _103_Solution:
    def zigzagLevelOrder(self, root: TreeNode) -> List[List[int]]:
        if root is None: return []
        ans = []
        queue = []
        queue.append(root)
        level = 0
        while queue:
            size = len(queue)
            partial = []
            for i in range(size):
                current = queue.pop(0)
                if current.left: queue.append(current.left)
                if current.right: queue.append(current.right)
                partial.append(current.val)
            if level % 2 == 1:
                ans.append(partial[::-1])
            else:
                ans.append(partial)
            level += 1
        return ans
