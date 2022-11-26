package easy

func reverseList(head *ListNode) *ListNode {
	var pre, curr, next *ListNode = nil, head, nil
	for curr != nil {
		next, curr.Next = curr.Next, pre
		pre, curr = curr, next
	}
	return pre
}
func reverseList1(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}
	last := reverseList(head.Next)
	head.Next.Next = head
	head.Next = nil
	return last
}
