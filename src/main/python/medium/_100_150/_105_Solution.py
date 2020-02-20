# 105. Construct Binary Tree from Preorder and Inorder Traversal
from typing import List

from src.main.python.TreeNode import TreeNode

'''[3,9,20,15,7]
[9,3,15,20,7]
[]
[]
[1]
[1]
[1,2]
[2,1]
[1,2]
[1,2]'''
class _105_Solution:
    'iterative'

    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if not preorder: return None
        j, stack = 0, []
        root = TreeNode(preorder[0])
        stack.append(root)
        node = None
        for i in range(1, len(preorder)):
            current = TreeNode(preorder[i])
            while stack and stack[-1].val == inorder[j]:
                node = stack.pop()
                j += 1
            if node:
                node.right = current
                node = None
            else:
                stack[-1].left = current
            stack.append(current)
        return root


if __name__ == '__main__':
    instance = _105_Solution
    assert instance.buildTree(instance, [3, 9, 20, 15, 7], [9, 3, 15, 20, 7])

    'recursive'
    # def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
    #     # if not preorder: return None
    #     # node = TreeNode(preorder[0])
    #     # index = inorder.index(preorder[0])
    #     # node.left = self.buildTree(preorder[1:index + 1], inorder[0:index])
    #     # node.right = self.buildTree(preorder[index + 1:], inorder[index + 1:])
    #     # return node
    #     def track(start: int, end: int) -> TreeNode:
    #         if start > end: return None
    #         current = TreeNode(preorder.pop(0))
    #         index = inorder.index(current.val, start, end + 1)
    #         current.left = track(start, index - 1)
    #         current.right = track(index + 1, end)
    #         return current
    #
    #     return track(0, len(inorder) - 1)
