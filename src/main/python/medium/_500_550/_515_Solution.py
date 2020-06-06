# 515. Find Largest Value in Each Tree Row
from typing import List

from src.main.python.TreeNode import TreeNode

'''
[1,3,2,5,3,null,9]
[]
[1]
[1,null,2]
[1,null,2,3,4,null,7]
'''


class _515_Solution:
    # bfs
    def largestValues(self, root: TreeNode) -> List[int]:
        if not root: return []
        q, ans = [root], []
        while q:
            size, maximal = len(q), -0xffffffff
            for i in range(size):
                curr = q.pop(0)
                maximal = max(curr.val, maximal)
                if curr.left: q.append(curr.left)
                if curr.right: q.append(curr.right)
            ans.append(maximal)
        return ans

    # dfs
    def largestValues(self, root: TreeNode) -> List[int]:
        if not root: return []
        ans = []

        def dfs(node: TreeNode, depth: int) -> None:
            if not node: return
            if depth == len(ans):
                ans.append(node.val)
            else:
                ans[depth] = max(ans[depth], node.val)
            dfs(node.left, depth + 1)
            dfs(node.right, depth + 1)

        dfs(root, 0)

        return ans
