package medium

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func bstFromPreorder(preorder []int) *TreeNode {
	var build func(l, r int) *TreeNode
	build = func(l, r int) *TreeNode {
		if l > r {
			return nil
		}
		curr := preorder[l]
		var idx = -1
		for i := l + 1; i <= r; i++ {
			if preorder[i] < curr {
				idx = i
			} else {
				break
			}
		}
		node := &TreeNode{Val: curr}
		node.Left, node.Right = build(l+1, idx), build(idx+1, r)
		return node
	}
	return build(0, len(preorder)-1)
}
func bstFromPreorder1(preorder []int) *TreeNode {
	if len(preorder) <= 0 {
		return nil
	}
	findMid := func(slice []int) int {
		head := slice[0]
		for i := 1; i < len(slice); i++ {
			if slice[i] > head {
				return i
			}
		}
		return len(slice)
	}
	mid := findMid(preorder)
	left, right := bstFromPreorder(preorder[1:mid]), bstFromPreorder(preorder[mid:])
	return &TreeNode{Val: preorder[0], Left: left, Right: right}
}
