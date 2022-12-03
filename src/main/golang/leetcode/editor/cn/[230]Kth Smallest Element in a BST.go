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
func kthSmallest(root *TreeNode, k int) (res int) {
	var j int
	var search func(node *TreeNode)
	search = func(node *TreeNode) {
		if node == nil {
			return
		}
		search(node.Left)
		j++
		if j == k {
			res = node.Val
			return
		}
		search(node.Right)
	}
	search(root)
	return
}

//leetcode submit region end(Prohibit modification and deletion)
