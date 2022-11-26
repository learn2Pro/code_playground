package hard

func reverseKGroup(head *ListNode, k int) *ListNode {
	reverse0 := func(start, end *ListNode) *ListNode {
		var pre, curr, next *ListNode = nil, start, nil
		for curr != end {
			next, curr.Next = curr.Next, pre
			pre, curr = curr, next
		}
		return pre
	}
	var b = head
	for i := 0; i < k; i++ {
		if b == nil {
			return head
		}
		b = b.Next
	}
	newly := reverse0(head, b)
	head.Next = reverseKGroup(b, k)
	return newly
}

func reverseKGroup1(head *ListNode, k int) *ListNode {

	var reverse0 func(node *ListNode, m, n int) *ListNode
	var reverseN func(node *ListNode, n int) *ListNode
	reverse0 = func(node *ListNode, m, n int) *ListNode {
		var successor *ListNode
		reverseN = func(ne *ListNode, x int) *ListNode {
			if x == 1 {
				successor = ne.Next
				return ne
			}
			last := reverseN(ne.Next, x-1)
			ne.Next.Next = ne
			ne.Next = successor
			return last
		}

		if m == 1 {
			return reverseN(node, n)
		}
		node.Next = reverse0(node.Next, m-1, n-1)
		return node
	}
	getSize := func(node *ListNode) int {
		var size int
		for node != nil {
			size += 1
			node = node.Next
		}
		return size
	}
	n := getSize(head)
	var q = []*ListNode{head}
	for i := 0; i < n; i += k {
		if i+k <= n {
			q = append(q, reverse0(q[len(q)-1], i+1, i+k))
		}
	}

	if len(q) > 1 {
		return q[1]
	}
	return q[0]
}
