# 199. Binary Tree Right Side View
from typing import List

from src.main.python.TreeNode import TreeNode


class _199_Solution:
    # recursive
    def rightSideView(self, root: TreeNode) -> List[int]:
        ans = []

        def dfs(node: TreeNode, level: int) -> None:
            if not node: return
            if len(ans) < level: ans.append(node.val)
            dfs(node.right, level + 1)
            dfs(node.left, level + 1)

        dfs(root, 1)
        return ans

        # bfs
    # def rightSideView(self, root: TreeNode) -> List[int]:
    #     ans = []
    #     if not root: return ans
    #     queue = deque()
    #     queue.append(root)
    #     while queue:
    #         size = len(queue)
    #         current = None
    #         for i in range(size):
    #             current = queue.popleft()
    #             if current.left: queue.append(current.left)
    #             if current.right: queue.append(current.right)
    #         ans.append(current.val)
    #     return ans
