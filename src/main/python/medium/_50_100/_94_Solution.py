# 94. Binary Tree Inorder Traversal
from typing import List

from src.main.python.TreeNode import TreeNode


class _94_Solution:
    # moris traversal
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        ans = []
        node = root
        while node:
            if node.left is None:
                ans.append(node.val)
                node = node.right
            else:
                prev = node.left
                while prev.right and prev.right != node: prev = prev.right
                if prev.right != node:
                    prev.right = node
                    node = node.left
                else:
                    prev.right = None
                    ans.append(node.val)
                    node = node.right
        return ans

    # stack

    # def inorderTraversal(self, root: TreeNode) -> List[int]:
    #     stack = []
    #     ans = []
    #     node = root
    #     while node: stack.append(node);node = node.left
    #     while stack:
    #         current = stack.pop()
    #         ans.append(current.val)
    #         current = current.right
    #         while current: stack.append(current);current = current.left
    #     return ans

    'recursive'
    # def inorderTraversal(self, root: TreeNode) -> List[int]:
    #     def inorder(node: TreeNode) -> List[int]:
    #         if node is None:
    #             return []
    #         return inorder(node.left) + [node.val] + inorder(node.right)
    #
    #     return inorder(root)

