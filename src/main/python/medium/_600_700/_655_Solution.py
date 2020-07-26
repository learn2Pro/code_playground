# 655. Print Binary Tree
"""
[1,2]
[1,2,3,null,4]
[1,2,5,3,null,4,null]
[1]
[1,null,3]
[1,2,null,4,null,5,null]
[1,2,null,4,null,5,null,6,null,7,null,8,null,9,null]
"""
from typing import List
from TreeNode import TreeNode


class _655_Solution:
    def printTree(self, root: TreeNode) -> List[List[str]]:
        if not root:
            return []
        queue, bfs, ans = [root], [], []
        while any(map(lambda x: x != None, queue)):
            size = len(queue)
            inner = []
            for i in range(size):
                current = queue.pop(0)
                inner.append(str(current.val) if current else "")
                queue.append(
                    current.left if current and current.left else None)
                queue.append(
                    current.right if current and current.right else None)
            bfs.append(inner)
        height, last = len(bfs), 0
        for i in reversed(range(height)):
            last = 2 * last + 1
            level = []
            for j in range(last // 2):
                level.append("")
            for index, val in enumerate(bfs[i]):
                level.append(val)
                if index != len(bfs[i]) - 1:
                    for jj in range(last):
                        level.append("")
            for j in range(last // 2):
                level.append("")
            ans.append(level)
        return reversed(ans)

    def printTree(self, root: TreeNode) -> List[List[str]]:
        def getHeight(node: TreeNode):
            if not node:
                return 0
            return 1 + max(getHeight(node.left), getHeight(node.right))

        h = getHeight(root)
        size = (1<<h) - 1
        ans = [[""] * (size) for i in range(h)]

        def fill(node, i, l, r):
            if not node: return
            ans[i][(l + r) // 2] = str(node.val)
            fill(node.left, i + 1, l, (l + r) // 2 - 1)
            fill(node.left, i + 1, (l + r) // 2 + 1, r)

        fill(root, 0, 0, size)
        return ans
