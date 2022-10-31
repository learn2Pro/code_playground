package medium

func deleteDuplicates(head *ListNode) *ListNode {
	dummy := &ListNode{Val: -101, Next: head}
	curr := dummy
	for curr.Next != nil && curr.Next.Next != nil {
		if curr.Next.Val == curr.Next.Next.Val {
			x := curr.Next.Val
			for curr.Next != nil && curr.Next.Val == x {
				curr.Next = curr.Next.Next
			}
		} else {
			curr = curr.Next
		}
	}
	return dummy.Next
}
