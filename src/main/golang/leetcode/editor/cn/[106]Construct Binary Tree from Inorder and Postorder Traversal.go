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
func buildTree(inorder []int, postorder []int) *TreeNode {
	var j = len(inorder) - 1
	var build func(l, r int) *TreeNode
	build = func(l, r int) *TreeNode {
		if l > r {
			return nil
		}
		curr := postorder[j]
		var idx = -1
		for i := 0; i <= r; i++ {
			if inorder[i] == curr {
				idx = i
				break
			}
		}
		node := &TreeNode{Val: curr}
		j--
		node.Right, node.Left = build(idx+1, r), build(l, idx-1)
		return node
	}
	return build(0, len(inorder)-1)
}

//leetcode submit region end(Prohibit modification and deletion)
