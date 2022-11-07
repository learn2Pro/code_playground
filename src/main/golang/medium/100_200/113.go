package medium

func pathSum(root *TreeNode, targetSum int) [][]int {
	var ans [][]int
	var tracker []int
	var backtrack func(node *TreeNode, sum int)
	backtrack = func(node *TreeNode, sum int) {
		if node == nil {
			return
		}
		if node.Left == nil && node.Right == nil && sum+node.Val == targetSum {
			var item = make([]int, len(tracker))
			copy(item, tracker)
			item = append(item, node.Val)
			ans = append(ans, item)
			return
		}
		tracker = append(tracker, node.Val)
		backtrack(node.Left, sum+node.Val)
		backtrack(node.Right, sum+node.Val)
		tracker = tracker[:len(tracker)-1]
	}

	backtrack(root, 0)
	return ans
}
