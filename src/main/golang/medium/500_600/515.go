package medium

//TreeNode Definition for a binary tree node.
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func largestValues(root *TreeNode) []int {
	Max := func(x, y int) int {
		if x < y {
			return y
		}
		return x
	}
	var ans []int
	if root == nil {
		return ans
	}
	var q = []*TreeNode{root}
	for len(q) > 0 {
		var size = len(q)
		var tmp []*TreeNode
		maxVal := q[0].Val
		for i := 0; i < size; i++ {
			maxVal = Max(maxVal, q[i].Val)
			if q[i].Left != nil {
				tmp = append(tmp, q[i].Left)
			}
			if q[i].Right != nil {
				tmp = append(tmp, q[i].Right)
			}
		}
		ans = append(ans, maxVal)
		q = tmp
	}
	return ans
}
