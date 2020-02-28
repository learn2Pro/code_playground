# 222. Count Complete Tree Nodes
from src.main.python.TreeNode import TreeNode

'''
[1,2,3,4,5,6]
[1,2]
[1,2,3]
[1]
[]
[1,2,3,4]
'''


class _222_Solution:
    # recursive
    def countNodes(self, root: TreeNode) -> int:
        def depth(node: TreeNode) -> int:
            if not node: return 0
            return 1 + depth(node.left)

        if not root: return 0
        l, r = depth(root.left), depth(root.right)
        if l == r:
            return 2 ** l + self.countNodes(root.right)
        else:
            return 2 ** r + self.countNodes(root.left)
    # def countNodes(self, root: TreeNode) -> int:
    #     if not root: return 0
    #     node = root
    #     level, remove = 0, 0
    #     while node: level += 1;node = node.left
    #
    #     def search(n: TreeNode, current: int) -> bool:
    #         if n and current == level:
    #             return True
    #         if not n:
    #             if current == level:
    #                 nonlocal remove
    #                 remove += 1
    #             return False
    #         passed = search(n.right, current + 1)
    #         if not passed: search(n.left, current + 1)
    #
    #     search(root, 1)
    #     return 2 ** level - 1 - remove
