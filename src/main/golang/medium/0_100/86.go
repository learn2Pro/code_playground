package medium

func partition(head *ListNode, x int) *ListNode {
	//dummy1 is smaller(<x)
	//dummy2 is bigger(>=x)
	dummy1, dummy2 := &ListNode{}, &ListNode{}
	p, p1, p2 := head, dummy1, dummy2
	for p != nil {
		if p.Val < x {
			p1.Next = p
			p1 = p1.Next
		} else {
			p2.Next = p
			p2 = p2.Next
		}
		//stop next
		tmp := p.Next
		p.Next = nil
		p = tmp
	}
	p1.Next = dummy2.Next
	return dummy1.Next
}
