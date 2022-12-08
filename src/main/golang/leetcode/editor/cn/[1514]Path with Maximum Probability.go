package lc

import "container/heap"

//leetcode submit region begin(Prohibit modification and deletion)
type Pair struct {
	to   int
	prob float64
}
type hp []Pair

func (h hp) Len() int              { return len(h) }
func (h hp) Less(i, j int) bool    { return h[i].prob > h[j].prob }
func (h hp) Swap(i, j int)         { h[i], h[j] = h[j], h[i] }
func (h *hp) Push(v interface{})   { *h = append(*h, v.(Pair)) }
func (h *hp) Pop() (v interface{}) { a := *h; *h, v = a[:len(a)-1], a[len(a)-1]; return }

//type hp []Pair
func maxProbability(n int, edges [][]int, succProb []float64, start int, end int) float64 {
	var graph = make([][]Pair, n)
	for i, edge := range edges {
		from, to := edge[0], edge[1]
		prop := succProb[i]
		graph[from] = append(graph[from], Pair{to: to, prob: prop})
		graph[to] = append(graph[to], Pair{to: from, prob: prop})
	}
	var probs = make([]float64, n)
	var queue = &hp{{to: start, prob: 1.0}}
	for queue.Len() > 0 {
		curr := heap.Pop(queue).(Pair)
		to, p := curr.to, curr.prob
		if p < probs[to] {
			continue
		}
		if to == end {
			return p
		}
		probs[to] = p
		for _, pair := range graph[to] {
			p1, next := p*pair.prob, pair.to
			if p1 > probs[next] {
				heap.Push(queue, Pair{to: next, prob: p1})
			}
		}
	}
	return probs[end]
}

//leetcode submit region end(Prohibit modification and deletion)
