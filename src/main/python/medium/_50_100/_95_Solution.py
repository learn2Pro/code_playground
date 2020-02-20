# 95. Unique Binary Search Trees II
from typing import List

from src.main.python.TreeNode import TreeNode


class _95_Solution:
    def generateTrees(self, n: int) -> List[TreeNode]:
        def generate(start: int, end: int) -> List[TreeNode]:
            if start > end:
                return [None]
            ans = []
            for i in range(start, end + 1):
                left, right = generate(start, i - 1), generate(i + 1, end)

                for l in left:
                    for r in right:
                        current = TreeNode(i)
                        current.left = l
                        current.right = r
                        ans.append(current)
            return ans

        if n <= 0: return []
        return generate(1, n)


if __name__ == '__main__':
    instance = _95_Solution
    assert instance.generateTrees(instance, 1) == None
    assert instance.generateTrees(instance, 2) == None
