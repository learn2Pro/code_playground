package lc

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func nextLargerNodes(head *ListNode) []int {
	var lst []int
	for head != nil {
		lst = append(lst, head.Val)
		head = head.Next
	}
	n := len(lst)
	var stack []int
	var ans = make([]int, n)
	for i := n - 1; i >= 0; i-- {
		curr := lst[i]
		for len(stack) > 0 && curr >= stack[len(stack)-1] {
			stack = stack[:len(stack)-1]
		}
		if len(stack) == 0 {
			ans[i] = 0
		} else {
			ans[i] = stack[len(stack)-1]
		}
		stack = append(stack, curr)
	}
	return ans

}

//leetcode submit region end(Prohibit modification and deletion)
