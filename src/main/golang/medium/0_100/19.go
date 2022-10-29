package medium

func removeNthFromEnd(head *ListNode, n int) *ListNode {
	dummy := &ListNode{Next: head}
	p1, p2 := dummy, dummy
	//found n-k
	for i := 0; i < n+1; i++ {
		p1 = p1.Next
	}
	for p1 != nil {
		p1 = p1.Next
		p2 = p2.Next
	}
	//found
	p2.Next = p2.Next.Next
	return dummy.Next
}
