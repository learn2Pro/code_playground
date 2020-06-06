# 513. Find Bottom Left Tree Value
from src.main.python.TreeNode import TreeNode


class _513_Solution:
    # bfs
    def findBottomLeftValue(self, root: TreeNode) -> int:
        q, leftmost = [root], None
        while q:
            size = len(q)
            for i in range(size):
                curr = q.pop()
                if i == 0: leftmost = curr.val
                if curr.left: q.append(curr.left)
                if curr.right: q.append(curr.right)
        return leftmost

    # dfs
    def findBottomLeftValue(self, root: TreeNode) -> int:
        h, ans = 0, None

        def dfs(node: TreeNode, depth: int) -> None:
            nonlocal h, ans
            if h < depth: ans = node.val;h = depth
            if node.left: dfs(node.left, depth + 1)
            if node.right: dfs(node.right, depth + 1)

        dfs(root, 1)
        return ans
