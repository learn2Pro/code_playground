package lc

import "container/heap"

//leetcode submit region begin(Prohibit modification and deletion)
type hp []int

func (h hp) Len() int                   { return len(h) }
func (h hp) Less(i, j int) bool         { return h[i] < h[j] }
func (h hp) Swap(i, j int)              { h[i], h[j] = h[j], h[i] }
func (h *hp) Push(v interface{})        { *h = append(*h, v.(int)) }
func (h *hp) Pop() (v interface{})      { a := *h; *h, v = a[:len(a)-1], a[len(a)-1]; return }
func (h *hp) Get(i int) (v interface{}) { a := *h; v = a[i]; return }

type MedianFinder struct {
	small, large *hp
}

func Constructor() MedianFinder {
	s, l := hp(make([]int, 0)), hp(make([]int, 0))
	return MedianFinder{small: &s, large: &l}
}

func (this *MedianFinder) AddNum(num int) {
	if len(*this.small) >= len(*this.large) {
		heap.Push(this.small, -num)
		v := heap.Pop(this.small)
		heap.Push(this.large, -v.(int))
	} else {
		heap.Push(this.large, num)
		v := heap.Pop(this.large)
		heap.Push(this.small, -v.(int))
	}
}

func (this *MedianFinder) FindMedian() float64 {
	if len(*this.large) > len(*this.small) {
		v := this.large.Get(0)
		return float64(v.(int))
	} else if len(*this.small) > len(*this.large) {
		v := this.small.Get(0)
		return float64(-v.(int))
	} else {
		v0 := this.small.Get(0)
		v1 := this.large.Get(0)
		return float64(-v0.(int)+v1.(int)) / 2.0
	}
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * obj := Constructor();
 * obj.AddNum(num);
 * param_2 := obj.FindMedian();
 */
//leetcode submit region end(Prohibit modification and deletion)
