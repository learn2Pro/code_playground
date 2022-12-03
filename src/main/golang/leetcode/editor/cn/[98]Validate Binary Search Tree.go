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
func isValidBST(root *TreeNode) bool {

	var isValid func(node, min, max *TreeNode) bool
	isValid = func(node, min, max *TreeNode) bool {
		if node == nil {
			return true
		}
		if min != nil && node.Val <= min.Val {
			return false
		}
		if max != nil && node.Val >= max.Val {
			return false
		}
		return isValid(node.Left, min, node) && isValid(node.Right, node, max)
	}
	return isValid(root, nil, nil)
}

//leetcode submit region end(Prohibit modification and deletion)
