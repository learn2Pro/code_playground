package lc

import "sort"

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func bstFromPreorder(preorder []int) *TreeNode {
	inorder := make([]int, len(preorder))
	copy(inorder, preorder)
	sort.Ints(inorder)
	var j int
	var build func(l, r int) *TreeNode
	build = func(l, r int) *TreeNode {
		if l > r {
			return nil
		}
		curr := preorder[j]
		var idx = -1
		for i := l; i <= r; i++ {
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
