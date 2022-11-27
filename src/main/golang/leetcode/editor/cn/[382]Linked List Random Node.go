package lc

import "math/rand"

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
type Solution struct {
	Node *ListNode
}

func Constructor(head *ListNode) Solution {
	return Solution{Node: head}
}

func (this *Solution) GetRandom() (res int) {
	var i int
	var current = this.Node
	for current != nil {
		i++
		x := rand.Intn(i)
		if x == 0 {
			res = current.Val
		}
		current = current.Next
	}
	return
}

/**
 * Your Solution object will be instantiated and called as such:
 * obj := Constructor(head);
 * param_1 := obj.GetRandom();
 */
//leetcode submit region end(Prohibit modification and deletion)
