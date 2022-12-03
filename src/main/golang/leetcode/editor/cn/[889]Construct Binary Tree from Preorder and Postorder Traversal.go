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
func constructFromPrePost(preorder []int, postorder []int) *TreeNode {
	var j int
	var build func(l, r int) *TreeNode
	build = func(l, r int) *TreeNode {
		if l > r {
			return nil
		}
		if l == r { //j=n-1
			node := &TreeNode{Val: preorder[j]}
			j++
			return node
		}
		curr, next := preorder[j], preorder[j+1]
		var idx = -1
		for i := l; i <= r; i++ {
			if postorder[i] == next {
				idx = i
				break
			}
		}
		node := &TreeNode{Val: curr}
		j++
		node.Left, node.Right = build(l, idx), build(idx+1, r-1)
		return node
	}
	return build(0, len(postorder)-1)
}

//leetcode submit region end(Prohibit modification and deletion)
