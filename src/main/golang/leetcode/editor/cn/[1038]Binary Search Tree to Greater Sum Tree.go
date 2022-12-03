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
func bstToGst(root *TreeNode) *TreeNode {
	var sum int
	var search func(node *TreeNode)
	search = func(node *TreeNode) {
		if node == nil {
			return
		}
		search(node.Right)
		sum += node.Val
		node.Val = sum
		search(node.Left)
	}
	search(root)
	return root
}
//leetcode submit region end(Prohibit modification and deletion)
