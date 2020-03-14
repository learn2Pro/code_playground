# 230. Kth Smallest Element in a BST
from src.main.python.TreeNode import TreeNode

'''
[3,1,4,null,2]
1
[5,3,6,2,4,null,null,1]
3
[]
0
[1]
1
[2,1]
2
[2,1,3,4,null,null,5]
3
[2,1,3,4,null,null,5]
5
'''


class _230_Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        if not root: return -1
        stack = []
        counter = 0
        while root: stack.append(root);root = root.left;
        while stack:
            current = stack.pop()
            counter += 1
            if counter == k: return current.val
            if current.right:
                current = current.right
                while current: stack.append(current);current = current.left;
