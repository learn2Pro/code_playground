package medium

func reverseBetween(head *ListNode, left int, right int) *ListNode {

	var successor *ListNode
	var reverseN func(node *ListNode, n int) *ListNode
	reverseN = func(node *ListNode, n int) *ListNode {
		if n == 1 {
			successor = node.Next
			return node
		}
		last := reverseN(node.Next, n-1)
		node.Next.Next = node
		node.Next = successor
		return last
	}

	if left == 1 {
		return reverseN(head, right)
	}
	head.Next = reverseBetween(head.Next, left-1, right-1)
	return head
}
