package easy

//TreeNode Definition for a binary tree node.
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func maxDepth(root *TreeNode) int {
	max := func(a, b int) int {
		if a > b {
			return a
		} else {
			return b
		}
	}
	var traversal func(node *TreeNode, depth int) int
	traversal = func(node *TreeNode, depth int) int {
		if node == nil {
			return depth
		}
		return max(traversal(node.Left, depth+1), traversal(node.Right, depth+1))
	}
	return traversal(root, 0)
}
