package easy

//TreeNode Definition for a binary tree node.
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func sumRootToLeaf(root *TreeNode) int {
	ans := 0
	var sumRootToLeaf0 func(node *TreeNode, preSum int)
	sumRootToLeaf0 = func(node *TreeNode, preSum int) {
		if node == nil {
			return
		}
		preSum = preSum<<1 + node.Val
		if node.Left == nil && node.Right == nil {
			ans += preSum
			return
		}
		sumRootToLeaf0(node.Left, preSum)
		sumRootToLeaf0(node.Right, preSum)
	}
	sumRootToLeaf0(root, 0)
	return ans
}
