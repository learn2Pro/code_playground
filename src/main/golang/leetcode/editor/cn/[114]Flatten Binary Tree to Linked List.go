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
func flatten(root *TreeNode) {
	if root == nil {
		return
	}
	flatten(root.Left)
	flatten(root.Right)
	l, r := root.Left, root.Right
	root.Left, root.Right = nil, l
	var p = root
	for p.Right != nil {
		p = p.Right
	}
	p.Right = r
}

//leetcode submit region end(Prohibit modification and deletion)
