# tree testify klazz
# inorder
# preorder
# postorder
# reconstruct by inoder and preorder
from typing import List
from src.main.python.TreeNode import TreeNode


class TreeTestify:
    def inorder(self, node: TreeNode):
        # ans, stack = [], []
        # while node:
        #     stack.append(node)
        #     node = node.left
        # while stack:
        #     current = stack.pop()
        #     ans.append(current.val)
        #     current = current.right
        #     while current:
        #         stack.append(current)
        #         current = current.left
        # return ans
        ans, stack = [], []
        while not node or stack:
            while node:
                stack.append(node)
                node = node.left
            current = stack.pop()
            ans.append(current.val)
            current = current.right
        return ans

    def preorder(self, node: TreeNode):
        ans, stack = [], []
        while not node or stack:
            while node:
                stack.append(node)
                ans.append(node.val)
                node = node.left
            node = stack.pop().right
        return ans

    def postorder(self, node: TreeNode):
        ans, stack = [], []
        while not node or stack:
            while node:
                stack.append(node)
                ans.append(node.val)
                node = node.right
            node = stack.pop().left
        return reversed(ans)

    def reconInAndPre(self, preorder: List[int], inorder: List[int]):
        if not preorder:
            return None
        root, node, j = TreeNode(preorder[0]), None, 0
        stack = [root]
        for i in range(1, len(preorder)):
            current = TreeNode(preorder[i])
            while stack and stack[-1].val == inorder[j]:
                node = stack.pop()
                j += 1
            if not node:
                stack[-1].left = current
            else:
                node.right = current
                node = None
            stack.append(current)
        return root

    def reconInAndPre0(self, preorder: List[int], inorder: List[int]):
        if not preorder:
            return None
        indexes = {v: idx for idx, v in enumerate(preorder)}

        def reconstruct(left, right):
            if left > right:
                return None
            root = TreeNode(preorder.pop(0))
            root.left = reconstruct(left, indexes[root.val]-1)
            root.right = reconstruct(indexes[root.val]+1, right)
            return root
        return reconstruct(0, len(inorder)-1)

    def reconInAndPost(self, postorder: List[int], inorder: List[int]):
        if not postorder:
            return None
        root, node, j = TreeNode(postorder[-1]), None, len(inorder)-1
        stack = [root]
        for i in reversed(range(len(postorder)-1)):
            current = TreeNode(postorder[i])
            while stack and stack[-1].val == inorder[j]:
                node = stack.pop()
                j -= 1
            if not node:
                stack[-1].right = current
            else:
                node.left, node = current, None
            stack.append(current)
        return root
    
    def reconInAndPost0(self, postorder: List[int], inorder: List[int]):
        if not postorder:
            return None
        indexes = {v: idx for idx, v in enumerate(postorder)}

        def reconstruct(left, right):
            if left > right:
                return None
            root = TreeNode(postorder.pop())
            root.left = reconstruct(left, indexes[root.val]-1)
            root.right = reconstruct(indexes[root.val]+1, right)
            return root
        return reconstruct(0, len(inorder)-1)
