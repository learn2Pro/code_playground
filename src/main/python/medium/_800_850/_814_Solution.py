# 814. Binary Tree Pruning
from TreeNode import TreeNode

'''
[1,null,0,0,1]
[1]
[0,1,null]
[0,0,0]
[0]
[0,0,1,0,0]
[]
[1,1,1,0]
[0,null,0]
'''


class _814_Solution:
    def pruneTree(self, root: TreeNode) -> TreeNode:
        if not root: return root

        def traversal(parent: TreeNode, node: TreeNode, left: bool) -> bool:
            if not node: return True
            l = traversal(node, node.left, True)
            r = traversal(node, node.right, False)
            if l and r and node.val == 0:
                if left:
                    parent.left = None
                else:
                    parent.right = None
            return node.val == 0 and l and r

        rootroot = TreeNode(-1)
        rootroot.right = root
        traversal(rootroot, root, False)
        return rootroot.right

    def pruneTree(self, root: TreeNode) -> TreeNode:
        def containsOne(node):
            if not node: return False
            l, r = containsOne(node.left), containsOne(node.right)
            if not l: node.left = None
            if not r: node.right = None
            return node.val == 1 or l or r

        return root if containsOne(root) else None
