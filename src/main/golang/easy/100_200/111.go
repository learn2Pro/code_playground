package easy

func minDepth(root *TreeNode) int {
	if root == nil {
		return 0
	}
	var q []*TreeNode
	var depth = 1
	q = append(q, root)
	for len(q) > 0 {
		size := len(q)
		for i := 0; i < size; i++ {
			head := q[0]
			q = q[1:]
			if head.Left == nil && head.Right == nil {
				return depth
			}
			if head.Left != nil {
				q = append(q, head.Left)
			}
			if head.Right != nil {
				q = append(q, head.Right)
			}
		}
		depth++
	}
	return depth
}
