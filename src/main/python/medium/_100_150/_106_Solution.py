# 106. Construct Binary Tree from Inorder and Postorder Traversal
from typing import List

from src.main.python.TreeNode import TreeNode


class _106_Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        if not inorder: return None
        j, node = len(inorder) - 1, None
        root = TreeNode(postorder[-1])
        stack = []
        stack.append(root)
        for i in range(len(postorder) - 2, -1, -1):
            current = TreeNode(postorder[i])
            while stack and stack[-1].val == inorder[j]:
                node = stack.pop()
                j -= 1
            if node:
                node.left = current
                node = None
            else:
                stack[-1].right = current
            stack.append(current)
        return root


if __name__ == '__main__':
    instance = _106_Solution
    assert instance.buildTree(instance, [9, 3, 15, 20, 7], [9, 15, 7, 20, 3]) == None
