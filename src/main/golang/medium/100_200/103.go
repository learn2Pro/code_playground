package medium

func zigzagLevelOrder(root *TreeNode) [][]int {

	var ans [][]int
	var q []*TreeNode
	if root == nil {
		return ans
	}
	q = append(q, root)
	var step = 0
	for len(q) > 0 {
		var tmp []*TreeNode
		var values []int
		for i := 0; i < len(q); i++ {
			curr := q[i]
			values = append(values, curr.Val)
			if curr.Left != nil {
				tmp = append(tmp, curr.Left)
			}
			if curr.Right != nil {
				tmp = append(tmp, curr.Right)
			}
		}
		if step%2 == 1 {
			for i, j := 0, len(values)-1; i < j; i, j = i+1, j-1 {
				values[i], values[j] = values[j], values[i]
			}
		}
		ans = append(ans, values)
		q = tmp
		step++
	}
	return ans
}
