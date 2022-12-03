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
func buildTree(preorder []int, inorder []int) *TreeNode {
	var j int
	var build func(l, r int) *TreeNode
	build = func(l, r int) *TreeNode {
		if l > r {
			return nil
		}
		curr := preorder[j]
		var idx = -1
		for i := 0; i <= r; i++ {
			if inorder[i] == curr {
				idx = i
				break
			}
		}
		node := &TreeNode{Val: curr}
		j++
		node.Left, node.Right = build(l, idx-1), build(idx+1, r)
		return node
	}
	return build(0, len(inorder)-1)
}

//leetcode submit region end(Prohibit modification and deletion)
