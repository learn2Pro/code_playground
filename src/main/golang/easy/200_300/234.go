package easy

//ListNode Definition for singly-linked list.
type ListNode struct {
	Val  int
	Next *ListNode
}

func isPalindrome(head *ListNode) bool {
	var start = head
	var ans = true
	var traversal func(curr *ListNode) *ListNode
	traversal = func(curr *ListNode) *ListNode {
		if curr.Next == nil {
			return curr
		}
		last := traversal(curr.Next)
		if start.Val == last.Val && ans {
			start = start.Next
			return curr
		} else {
			ans = false
			return curr
		}
	}
	traversal(head)
	return ans
}
func isPalindrome1(head *ListNode) bool {
	var pre *ListNode
	slow, fast := head, head
	step := 0
	for fast != nil && fast.Next != nil {
		tmp := slow
		slow, fast = slow.Next, fast.Next.Next
		tmp.Next, pre = pre, tmp
		step++
	}
	if fast == nil { // even
		slow, fast = pre, slow
	} else { // odd
		slow, fast = pre, slow.Next
	}
	for slow != nil && fast != nil {
		if slow.Val != fast.Val {
			return false
		}
		slow, fast = slow.Next, fast.Next
	}
	return true

}
