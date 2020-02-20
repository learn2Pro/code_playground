# 114. Flatten Binary Tree to Linked List
from src.main.python.TreeNode import TreeNode


class Solution:
    def flatten(self, root: TreeNode) -> None:
        while root:
            if root.left and root.right:
                node = root.left
                while node.right: node = node.right
                node.right = root.right
            if root.left:
                root.right = root.left
                root.left = None
            root = root.right

    # def flatten(self, root: TreeNode) -> None:
    #     """
    #             Do not return anything, modify root in-place instead.
    #             """
    #     if not root: return
    #     stack = []
    #     stack.append(root)
    #     while stack:
    #         current = stack.pop()
    #         if current.right:
    #             stack.append(current.right)
    #         if current.left:
    #             stack.append(current.left)
    #         if stack:
    #             current.right = stack[-1]
    #         current.left = None

    # def flatten(self, root: TreeNode) -> None:
    #     """
    #     Do not return anything, modify root in-place instead.
    #     """
    #     if not root: return
    #     stack = []
    #     ans = []
    #     node = root
    #     while node: stack.append(node);ans.append(node);node = node.left;
    #     while stack:
    #         current = stack.pop()
    #         node = current.right
    #         while node: stack.append(node);ans.append(node);node = node.left;
    #
    #     node = ans[0]
    #     node.left = None
    #     for i in range(1, len(ans)):
    #         node.right = ans[i]
    #         node = ans[i]
    #         node.left = None
    #     return root
