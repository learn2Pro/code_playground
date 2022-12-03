# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', nodes: 'List[TreeNode]') -> 'TreeNode':
        node_sets = set(nodes)

        def lcs(root: TreeNode) -> TreeNode:
            if root == None:
                return None
            if root in node_sets:
                return root
            left, right = lcs(root.left), lcs(root.right)
            if left != None and right != None:
                return root
            return right if left == None else left

        return lcs(root)
