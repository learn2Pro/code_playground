package lc

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val   int
 *     Left  *TreeNode
 *     Right *TreeNode
 * }
 */

func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
	//if root == nil {
	//	return nil
	//}
	//if root == p || root == q {
	//	return root
	//}
	//lson, rson := lowestCommonAncestor(root.Left, p, q), lowestCommonAncestor(root.Right, p, q)
	//if lson != nil && rson != nil {
	//	return root
	//}
	//if lson == nil {
	//	return rson
	//}
	//return lson
	if root == nil {
		return nil
	}
	if p.Val > q.Val {
		return lowestCommonAncestor(root, q, p)
	}
	if root.Val >= p.Val && root.Val <= q.Val {
		return root
	}
	if q.Val < root.Val {
		return lowestCommonAncestor(root.Left, p, q)
	} else {
		return lowestCommonAncestor(root.Right, p, q)
	}
}

//leetcode submit region end(Prohibit modification and deletion)
