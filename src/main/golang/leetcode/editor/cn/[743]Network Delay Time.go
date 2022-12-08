package lc

import (
	"container/heap"
	"math"
)

//leetcode submit region begin(Prohibit modification and deletion)
type hp [][]int

func (h hp) Len() int              { return len(h) }
func (h hp) Less(i, j int) bool    { return h[i][1] < h[j][1] }
func (h hp) Swap(i, j int)         { h[i], h[j] = h[j], h[i] }
func (h *hp) Push(v interface{})   { *h = append(*h, v.([]int)) }
func (h *hp) Pop() (v interface{}) { a := *h; *h, v = a[:len(a)-1], a[len(a)-1]; return }

func networkDelayTime(times [][]int, n int, k int) int {
	var cost = make([]int, n)
	for i := 0; i < n; i++ {
		cost[i] = math.MaxInt32
	}
	var graph = make([][][]int, n)
	for _, time := range times {
		u, v := time[0]-1, time[1]-1
		graph[u] = append(graph[u], []int{v, time[2]})
	}
	var queue = &hp{{k - 1, 0}}
	for queue.Len() > 0 {
		curr := heap.Pop(queue).([]int)
		from, w := curr[0], curr[1]
		if w > cost[from] {
			continue
		}
		cost[from] = w
		for _, tuple := range graph[from] {
			to, w1 := tuple[0], tuple[1]
			if w+w1 < cost[to] {
				heap.Push(queue, []int{to, w + w1})
			}
		}
	}
	var maximal int
	for _, w := range cost {
		if w > maximal {
			maximal = w
		}
	}
	if maximal == math.MaxInt32 {
		return -1
	}
	return maximal
}

//leetcode submit region end(Prohibit modification and deletion)
