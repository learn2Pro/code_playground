package medium

import (
	"container/heap"
	"math"
)

type hp [][]int

func (h hp) Len() int              { return len(h) }
func (h hp) Less(i, j int) bool    { return h[i][2] < h[j][2] }
func (h hp) Swap(i, j int)         { h[i], h[j] = h[j], h[i] }
func (h *hp) Push(v interface{})   { *h = append(*h, v.([]int)) }
func (h *hp) Pop() (v interface{}) { a := *h; *h, v = a[:len(a)-1], a[len(a)-1]; return }

func minimumEffortPath(heights [][]int) int {
	Max := func(x, y int) int {
		if x > y {
			return x
		}
		return y
	}
	Abs := func(x int) int {
		if x < 0 {
			return -x
		}
		return x
	}
	m, n := len(heights), len(heights[0])
	var cost = make([][]int, m)
	for i := 0; i < m; i++ {
		cost[i] = make([]int, n)
		for j := 0; j < n; j++ {
			cost[i][j] = math.MaxInt32
		}
	}
	var adj = [][]int{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}
	var queue = &hp{{0, 0, 0}}
	for queue.Len() > 0 {
		curr := heap.Pop(queue).([]int)
		x, y, w := curr[0], curr[1], curr[2]
		if w > cost[x][y] {
			continue
		}
		if x == m-1 && y == n-1 {
			return w
		}
		cost[x][y] = w
		for _, tuple := range adj {
			x0, y0 := x+tuple[0], y+tuple[1]
			if x0 < 0 || y0 < 0 || x0 >= m || y0 >= n {
				continue
			}
			w1 := Max(cost[x][y], Abs(heights[x][y]-heights[x0][y0]))
			if w1 < cost[x0][y0] {
				heap.Push(queue, []int{x0, y0, w1})
			}
		}
	}
	return cost[m-1][n-1]
}
