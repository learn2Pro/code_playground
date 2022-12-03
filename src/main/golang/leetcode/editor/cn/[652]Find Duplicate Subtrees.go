package lc

import "strconv"

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func findDuplicateSubtrees(root *TreeNode) []*TreeNode {
	var memo = make(map[string]int)
	var ans []*TreeNode
	var postorder func(node *TreeNode) string
	postorder = func(node *TreeNode) string {
		if node == nil {
			return "#"
		}
		l, r := postorder(node.Left), postorder(node.Right)
		str := l + "," + r + "," + strconv.Itoa(node.Val)
		num := memo[str]
		if num == 1 {
			ans = append(ans, node)
		}
		memo[str] += 1
		return str
	}
	postorder(root)
	return ans
}

//leetcode submit region end(Prohibit modification and deletion)
