package medium

//TreeNode Definition for a binary tree node.
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func rob(root *TreeNode) int {
	Max := func(x, y int) int {
		if x > y {
			return x
		} else {
			return y
		}
	}
	var rob0 func(node *TreeNode) (int, int)
	rob0 = func(node *TreeNode) (int, int) {
		if node == nil {
			return 0, 0
		}
		dp_l_0, dp_l_1 := rob0(node.Left)
		dp_r_0, dp_r_1 := rob0(node.Right)
		return Max(dp_l_0+dp_r_0, Max(Max(dp_l_0+dp_r_1, dp_l_1+dp_r_0), dp_l_1+dp_r_1)), dp_l_0 + dp_r_0 + node.Val
	}

	d0, d1 := rob0(root)
	return Max(d0, d1)
}
