package medium

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func bstFromPreorder(preorder []int) *TreeNode {
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
