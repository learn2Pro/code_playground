package medium

func levelOrder(root *TreeNode) [][]int {
	var ans [][]int
	var q []*TreeNode
	if root == nil {
		return ans
	}
	q = append(q, root)
	for len(q) > 0 {
		var level []int
		var tmp []*TreeNode
		for i := 0; i < len(q); i++ {
			curr := q[i]
			level = append(level, curr.Val)
			if curr.Left != nil {
				tmp = append(tmp, curr.Left)
			}
			if curr.Right != nil {
				tmp = append(tmp, curr.Right)
			}
		}
		q = tmp
		ans = append(ans, level)
	}
	return ans
}
