package lc

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
	//----------------->dfs---------------->
	//var contains func(node *TreeNode) bool
	//contains = func(node *TreeNode) bool {
	//	if node == nil {
	//		return false
	//	}
	//	lson, rson := contains(node.Left), contains(node.Right)
	//	if (lson && rson) || ((node == p || node == q) && (lson || rson)) {
	//		ans = node
	//	}
	//	return node == p || node == q || lson || rson
	//}
	//contains(root)
	//return
	//----------------->hashmap---------------->
	//parent := make(map[*TreeNode]*TreeNode)
	//visited := make(map[*TreeNode]bool)
	//var dfs func(node *TreeNode)
	//dfs = func(node *TreeNode) {
	//	if node.Left != nil {
	//		parent[node.Left] = node
	//		dfs(node.Left)
	//	}
	//	if node.Right != nil {
	//		parent[node.Right] = node
	//		dfs(node.Right)
	//	}
	//}
	//parent[root] = nil
	//dfs(root)
	//for p != nil {
	//	visited[p] = true
	//	p = parent[p]
	//}
	//for q != nil {
	//	if visited[q] {
	//		return q
	//	}
	//	q = parent[q]
	//}
	//return nil
	if root == nil {
		return nil
	}
	if root == p || root == q {
		return root
	}
	left := lowestCommonAncestor(root.Left, p, q)
	right := lowestCommonAncestor(root.Right, p, q)
	if left != nil && right != nil {
		return root
	}
	if left == nil {
		return right
	}
	return left
}

//leetcode submit region end(Prohibit modification and deletion)
