package medium

import (
	"container/heap"
	"math"
)

type hp [][]int

func (h hp) Len() int              { return len(h) }
func (h hp) Less(i, j int) bool    { return h[i][1] < h[j][1] }
func (h hp) Swap(i, j int)         { h[i], h[j] = h[j], h[i] }
func (h *hp) Push(v interface{})   { *h = append(*h, v.([]int)) }
func (h *hp) Pop() (v interface{}) { a := *h; *h, v = a[:len(a)-1], a[len(a)-1]; return }

func findCheapestPrice(n int, flights [][]int, src int, dst int, k int) int {
	//Min := func(x, y int) int {
	//	if x < y {
	//		return x
	//	}
	//	return y
	//}
	//matrix := make([][]int, n)
	//for i := 0; i < n; i++ {
	//	matrix[i] = make([]int, n)
	//}
	//for _, triple := range flights {
	//	from, to, price := triple[0], triple[1], triple[2]
	//	matrix[from][to] = price
	//}
	//dp := make([][]int, n) //dp[i][k]，处于i这个位置，第k次stop，最小花费
	//for i := 0; i < n; i++ {
	//	dp[i] = make([]int, k+2)
	//	for j := 0; j < k+2; j++ {
	//		dp[i][j] = 0x7fffffff
	//	}
	//}
	//var res = math.MaxInt32
	//dp[src][0] = 0
	//for x := 1; x <= k+1; x++ {
	//	for from := 0; from < n; from++ {
	//		for to, price := range matrix[from] {
	//			if price == 0 || dp[from][x-1] == math.MaxInt32 {
	//				continue
	//			}
	//			dp[to][x] = Min(dp[to][x], dp[from][x-1]+price)
	//			if to == dst {
	//				res = Min(res, dp[to][x])
	//			}
	//		}
	//	}
	//}
	//if res == math.MaxInt32 {
	//	return -1
	//}
	//return res
	//Min := func(x, y int) int {
	//	if x < y {
	//		return x
	//	}
	//	return y
	//}
	routing := make([][][]int, n)
	for _, flight := range flights {
		routing[flight[0]] = append(routing[flight[0]], []int{flight[1], flight[2]})
	}
	visited := make([]int, n)
	for i := 0; i < n; i++ {
		visited[i] = math.MaxInt32
	}
	visited[src] = 0
	var queue = &hp{{src, 0, 0}}
	for queue.Len() > 0 {
		curr := heap.Pop(queue).([]int)
		from, p, step := curr[0], curr[1], curr[2]
		if step > k+1 {
			continue
		}
		if from == dst {
			return p
		}
		visited[from] = p
		for _, v := range routing[from] {
			next, price := v[0], v[1]
			cost := p + price
			if cost > visited[next] {
				continue
			}
			heap.Push(queue, []int{next, p + price, step + 1})
		}
	}
	return -1
}
