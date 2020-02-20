# 144. Binary Tree Preorder Traversal
from typing import List

from src.main.python.TreeNode import TreeNode


class _144_Solution:
    # recursive
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        def preorder(node: TreeNode) -> List[int]:
            if node is None:
                return []
            return [node.val] + preorder(node.left) + preorder(node.right)

        return preorder(root)
    # stack
    # def preorderTraversal(self, root: TreeNode) -> List[int]:
    #     ans = []
    #     stack = []
    #     node = root
    #     while node: stack.append(node);ans.append(node.val);node = node.left;
    #     while stack:
    #         current = stack.pop()
    #         current = current.right
    #         while current: stack.append(current);ans.append(current.val);current = current.left;
    #     return ans

    # moris
    # def preorderTraversal(self, root: TreeNode) -> List[int]:
    #     ans = []
    #     node = root
    #     while node:
    #         if node.left is None:
    #             ans.append(node.val)
    #             node = node.right
    #         else:
    #             prev = node.left
    #             while prev.right and prev.right != node: prev = prev.right
    #             if prev.right != node:
    #                 prev.right = node
    #                 node = node.left
    #             else:
    #                 prev.right = None
    #                 ans.append(node.left.val)
    #                 node = node.right
    #     return ans
