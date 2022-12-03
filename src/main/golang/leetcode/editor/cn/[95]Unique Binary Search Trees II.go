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
func generateTrees(n int) []*TreeNode {

	var build func(l, r int) []*TreeNode
	build = func(l, r int) []*TreeNode {
		if l > r {
			return []*TreeNode{nil}
		}
		var ans []*TreeNode
		for i := l; i <= r; i++ {
			leftChilds := build(l, i-1)
			rightChilds := build(i+1, r)
			for _, left := range leftChilds {
				for _, right := range rightChilds {
					node := &TreeNode{Val: i}
					node.Left = left
					node.Right = right
					ans = append(ans, node)
				}
			}
		}
		return ans
	}
	return build(1, n)
}

//leetcode submit region end(Prohibit modification and deletion)
