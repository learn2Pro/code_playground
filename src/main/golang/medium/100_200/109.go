package medium

//TreeNode Definition for a binary tree node.
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func sortedListToBST(head *ListNode) *TreeNode {
	getLen := func(node *ListNode) int {
		size := 0
		for ; node != nil; node = node.Next {
			size++
		}
		return size
	}
	var buildTree func(start, end int) *TreeNode
	buildTree = func(start, end int) *TreeNode {
		if start > end {
			return nil
		}
		mid := (start + end + 1) / 2
		root := &TreeNode{}
		root.Left = buildTree(start, mid-1)
		root.Val = head.Val
		head = head.Next
		root.Right = buildTree(mid+1, end)
		return root
	}
	length := getLen(head)
	return buildTree(0, length-1)
}

//func sortedListToBST(head *ListNode) *TreeNode {
//	findMid := func(node *ListNode) *ListNode {
//		pre, slow, fast := node, node, node
//		for fast != nil && fast.Next != nil {
//			pre = slow
//			slow, fast = slow.Next, fast.Next.Next
//		}
//		pre.Next = nil
//		return slow
//	}
//	if head == nil {
//		return nil
//	}
//	if head.Next == nil {
//		return &TreeNode{Val: head.Val}
//	}
//	mid := findMid(head)
//	left, right := sortedListToBST(head), sortedListToBST(mid.Next)
//	return &TreeNode{Val: mid.Val, Left: left, Right: right}
//}
