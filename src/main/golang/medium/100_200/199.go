package medium

func rightSideView(root *TreeNode) []int {
	var ans []int
	if root == nil {
		return ans
	}
	var q = []*TreeNode{root}
	for len(q) > 0 {
		var size = len(q)
		var tmp []*TreeNode
		ans = append(ans, q[size-1].Val)
		for i := 0; i < size; i++ {
			if q[i].Left != nil {
				tmp = append(tmp, q[i].Left)
			}
			if q[i].Right != nil {
				tmp = append(tmp, q[i].Right)
			}
		}
		q = tmp
	}
	return ans
}
