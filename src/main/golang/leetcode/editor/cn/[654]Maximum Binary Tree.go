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
func constructMaximumBinaryTree(nums []int) *TreeNode {
	var build func(l, r int) *TreeNode
	build = func(l, r int) *TreeNode {
		if l > r {
			return nil
		}
		var val, idx = -1, -1
		for i := l; i <= r; i++ {
			if nums[i] > val {
				idx = i
				val = nums[i]
			}
		}
		node := &TreeNode{Val: val}
		node.Left, node.Right = build(l, idx-1), build(idx+1, r)
		return node
	}

	return build(0, len(nums)-1)
}

//leetcode submit region end(Prohibit modification and deletion)
