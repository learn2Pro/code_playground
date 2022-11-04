package medium

type ListNode struct {
	Val  int
	Next *ListNode
}

func detectCycle(head *ListNode) *ListNode {
	curr, visited := head, make(map[*ListNode]bool)
	for ; curr != nil; curr = curr.Next {
		if _, ok := visited[curr]; ok {
			return curr
		}
		visited[curr] = true

	}
	return nil
}

//func detectCycle(head *ListNode) *ListNode {
//	if head == nil {
//		return nil
//	}
//	getCycleNode := func(fast *ListNode) *ListNode {
//		slow := head
//		for slow != fast {
//			slow, fast = slow.Next, fast.Next
//		}
//		return slow
//	}
//	slow, fast := head, head
//	for fast != nil && fast.Next != nil {
//		slow, fast = slow.Next, fast.Next.Next
//		if slow == fast {
//			return getCycleNode(fast)
//		}
//	}
//	return nil
//}
