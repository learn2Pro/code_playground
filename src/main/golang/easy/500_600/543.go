package easy

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func diameterOfBinaryTree(root *TreeNode) int {
	max := func(a, b int) int {
		if a > b {
			return a
		} else {
			return b
		}
	}
	ans := 0
	var maxDepth func(node *TreeNode) int
	maxDepth = func(node *TreeNode) int {
		if node == nil {
			return 0
		}
		mleft, mright := maxDepth(node.Left), maxDepth(node.Right)
		ans = max(ans, mleft+mright)
		return 1 + max(mleft, mright)
	}
	maxDepth(root)
	return ans

}
