package lc

//ListNode Definition for singly-linked list.
type ListNode struct {
	Val  int
	Next *ListNode
}

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func reverseList(head *ListNode) *ListNode {
	//var pre, curr, next *ListNode = nil, head, nil
	//for curr != nil {
	//	next, curr.Next = curr.Next, pre
	//	pre, curr = curr, next
	//}
	//return pre
	if head == nil || head.Next == nil {
		return head
	}
	last := reverseList(head.Next)
	head.Next.Next, head.Next = head, nil
	return last
}

//leetcode submit region end(Prohibit modification and deletion)
