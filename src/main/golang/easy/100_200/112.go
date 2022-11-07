package easy

func hasPathSum(root *TreeNode, targetSum int) bool {

	var pathSum func(node *TreeNode, currentSum int) bool
	pathSum = func(node *TreeNode, currentSum int) bool {
		if node == nil {
			return false
		}
		if node.Left == nil && node.Right == nil {
			return currentSum+node.Val == targetSum
		}
		return pathSum(node.Left, currentSum+node.Val) || pathSum(node.Right, currentSum+node.Val)
	}
	if root == nil {
		return false
	}
	return pathSum(root, 0)
}
