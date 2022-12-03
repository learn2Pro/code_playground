package lc

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func deleteNode(root *TreeNode, key int) *TreeNode {
	getMinNode := func(node *TreeNode) *TreeNode {
		for node.Left != nil {
			node = node.Left
		}
		return node
	}
	if root == nil {
		return nil
	}
	if root.Val == key {
		if root.Left == nil {
			return root.Right
		}
		if root.Right == nil {
			return root.Left
		}
		minNode := getMinNode(root.Right)
		root.Right = deleteNode(root.Right, minNode.Val)
		minNode.Left, minNode.Right = root.Left, root.Right
		root = minNode
	} else if root.Val < key {
		root.Right = deleteNode(root.Right, key)
	} else {
		root.Left = deleteNode(root.Left, key)
	}
	return root
}

//leetcode submit region end(Prohibit modification and deletion)
