package medium

type Pair struct {
	to   int
	prob float64
}

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
	var queue = []Pair{{to: start, prob: 1.0}}
	for len(queue) > 0 {
		curr := queue[0]
		queue = queue[1:]
		to, p := curr.to, curr.prob
		if p < probs[to] {
			continue
		}
		probs[to] = p
		for _, pair := range graph[to] {
			p1, next := p*pair.prob, pair.to
			if p1 > probs[next] {
				queue = append(queue, Pair{to: next, prob: p1})
			}
		}
	}
	return probs[end]
}
