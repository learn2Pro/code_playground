package easy

//TreeNode Definition for a binary tree node.
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func averageOfLevels(root *TreeNode) []float64 {
	var ans []float64
	if root == nil {
		return ans
	}
	var q = []*TreeNode{root}
	for len(q) > 0 {
		var size = len(q)
		var tmp []*TreeNode
		sum := 0.0
		for i := 0; i < size; i++ {
			sum += float64(q[i].Val)
			if q[i].Left != nil {
				tmp = append(tmp, q[i].Left)
			}
			if q[i].Right != nil {
				tmp = append(tmp, q[i].Right)
			}
		}
		ans = append(ans, sum/float64(size))
		q = tmp
	}
	return ans
}
