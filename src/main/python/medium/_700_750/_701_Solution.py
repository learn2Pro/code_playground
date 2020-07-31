# 701. Insert into a Binary Search Tree
from TreeNode import TreeNode

'''
[4,2,7,1,3]
5
[]
1
[1]
2
[2]
1
[1,null,2]
3
[2,1]
3
[6,4,8,2,null,null,10]
1
[6,4,8,2,null,null,10]
3
[6,4,8,2,null,null,10]
5
[6,4,8,2,null,null,10]
7
[6,4,8,2,null,null,10]
9
[6,4,8,2,null,null,10]
11
'''


class _701_Solution:
    # use parent
    def insertIntoBST(self, root: TreeNode, val: int) -> TreeNode:
        if not root: return TreeNode(val)

        def replace(parent: TreeNode, node: TreeNode):
            if not node:
                if parent.val < val:
                    parent.right = TreeNode(val)
                else:
                    parent.left = TreeNode(val)
                return
            if val > node.val:
                replace(node, node.right)
            else:
                replace(node, node.left)

        replace(None, root)
        return root

    # simply
    def insertIntoBST(self, root: TreeNode, val: int) -> TreeNode:
        if not root: return TreeNode(val)
        if val > root.val:
            root.right = self.insertIntoBST(root.right, val)
        else:
            root.left = self.insertIntoBST(root.left, val)
        return root
