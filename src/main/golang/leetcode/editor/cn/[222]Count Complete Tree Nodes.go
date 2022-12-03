package lc

import "math"

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func countNodes(root *TreeNode) int {
	//if root == nil {
	//	return 0
	//}
	//return 1 + countNodes(root.Left) + countNodes(root.Right)
	l, r := root, root
	hl, hr := 0, 0
	for l != nil {
		l = l.Left
		hl++
	}
	for r != nil {
		r = r.Right
		hr++
	}
	if hl == hr {
		return int(math.Pow(2, float64(hl))) - 1
	}
	return 1 + countNodes(root.Left) + countNodes(root.Right)
}

//leetcode submit region end(Prohibit modification and deletion)
