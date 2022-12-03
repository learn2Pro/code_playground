
# There is no code of Go type for this problem
class Solution:
	def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
		ans = None

		def contains(node: 'TreeNode') -> bool:
			if node == None:
				return False
			lson, rson = contains(node.left), contains(node.right)
			if (lson and rson) or ((node == p or node == q) and (lson or rson)):
				nonlocal ans
				ans = node
			return node == p or node == q or lson or rson

		contains(root)
		return self.ans
