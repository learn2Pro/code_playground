# 450. Delete Node in a BST
from src.main.python.TreeNode import TreeNode

'''
[5,3,6,2,4,null,7]
3
[5,3,6,2,4,null,7]
7
[5,3,6,2,4,null,7]
4
[5,3,6,2,4,null,7]
2
[5,3,6,2,4,null,7]
6
[5,3,6,2,4,null,7]
3
[5,3,6,2,4,null,7]
5
[1]
1
[1]
2
[2,1]
1
[1,2]
1
[1,null,3]
3
[1,null,3]
1
[1,2,3]
1
[2,0,33,null,1,25,40,null,null,11,31,34,45,10,18,29,32,null,36,43,46,4,null,12,24,26,30,null,null,35,39,42,44,null,48,3,9,null,14,22,null,null,27,null,null,null,null,38,null,41,null,null,null,47,49,null,null,5,null,13,15,21,23,null,28,37,null,null,null,null,null,null,null,null,8,null,null,null,17,19,null,null,null,null,null,null,null,7,null,16,null,null,20,6]
33
'''


class _450_Solution:
    # use recursive
    def deleteNode(self, root: TreeNode, key: int) -> TreeNode:
        if not root: return root
        if root.val == key:
            if root.right:
                curr = root.right
                while curr.left: curr = curr.left
                curr.left = root.left
                return root.right
            else:
                return root.left
        elif root.val > key:
            root.left = self.deleteNode(root.left, key)
        else:
            root.right = self.deleteNode(root.right, key)
        return root

    # def deleteNode(self, root: TreeNode, key: int) -> TreeNode:
    #     if not root: return root
    #
    #     def search(parent: TreeNode, node: TreeNode) -> (TreeNode, TreeNode):
    #         if not node: return parent, None
    #         if node.val == key:
    #             return parent, node
    #         elif node.val < key:
    #             return search(node, node.right)
    #         else:
    #             return search(node, node.left)
    #
    #     def replace(parent: TreeNode, old: TreeNode, update: TreeNode):
    #         if parent.left == old:
    #             parent.left = update
    #         else:
    #             parent.right = update
    #
    #     rootroot = TreeNode(-1)
    #     rootroot.left = root
    #     parent, target = search(rootroot, root)
    #     if not target:
    #         return root
    #     elif not target.right:
    #         replace(parent, target, target.left)
    #     else:
    #         last, current = target, target.right
    #         while current.left:
    #             last = current
    #             current = current.left
    #         current.left = target.left
    #         tmp = current.right
    #         if last.right != current:
    #             current.right = target.right
    #         replace(parent, target, current)
    #         last.left = tmp
    #     return rootroot.left
