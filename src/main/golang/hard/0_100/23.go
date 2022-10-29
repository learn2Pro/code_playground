package hard

import "container/heap"

type ListNode struct {
	Val  int
	Next *ListNode
}

type MinNodeHeap []*ListNode

func (h MinNodeHeap) Len() int           { return len(h) }
func (h MinNodeHeap) Less(i, j int) bool { return h[i].Val < h[j].Val }
func (h MinNodeHeap) Swap(i, j int)      { h[i], h[j] = h[j], h[i] }

func (h *MinNodeHeap) Push(x interface{}) {
	// Push and Pop use pointer receivers because they modify the slice's length,
	// not just its contents.
	*h = append(*h, x.(*ListNode))
}

func (h *MinNodeHeap) Pop() interface{} {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

func mergeKLists(lists []*ListNode) *ListNode {
	dummy := &ListNode{}
	p := dummy
	var minHeap MinNodeHeap
	for _, head := range lists {
		if head != nil {
			heap.Push(&minHeap, head)
		}
	}
	for minHeap.Len() > 0 {
		node := heap.Pop(&minHeap).(*ListNode)
		p.Next = node
		if node.Next != nil {
			heap.Push(&minHeap, node.Next)
		}
		p = p.Next
	}
	return dummy.Next
}
