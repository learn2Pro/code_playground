package hard

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func maxPathSum(root *TreeNode) int {
	max := func(a, b int) int {
		if a > b {
			return a
		} else {
			return b
		}
	}
	ans := -1001
	var pathSum func(node *TreeNode) int
	pathSum = func(node *TreeNode) int {
		if node == nil {
			return 0
		}
		mleft, mright := max(pathSum(node.Left), 0), max(pathSum(node.Right), 0)
		ans = max(ans, mleft+mright+node.Val)
		return max(mleft, mright) + node.Val
	}
	pathSum(root)
	return ans
}
