package easy

func deleteDuplicates(head *ListNode) *ListNode {
	if head == nil {
		return head
	}
	slow, fast := head, head
	for fast != nil {
		if slow.Val != fast.Val {
			slow = slow.Next
			slow.Val = fast.Val
		}
		fast = fast.Next
	}
	slow.Next = nil
	return head
}
