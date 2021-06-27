package medium

type ListNode struct {
	Val  int
	Next *ListNode
}

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	var h0, h1 = l1, l2
	node := &ListNode{}
	var root, carry = node, 0
	for h0 != nil || h1 != nil {
		sum := GetVal(h0) + GetVal(h1) + carry
		var curr = &ListNode{}
		curr.Val, carry = sum%10, sum/10
		node.Next = curr
		node = node.Next
		h0, h1 = GetNext(h0), GetNext(h1)
	}
	if carry != 0 {
		node.Next = &ListNode{Val: carry}
	}
	return root.Next
}
func GetVal(node *ListNode) int {
	if node == nil {
		return 0
	} else {
		return node.Val
	}
}
func GetNext(node *ListNode) *ListNode {
	if node == nil {
		return nil
	} else {
		return node.Next
	}
}
