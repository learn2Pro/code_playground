package lc

import "sort"

//leetcode submit region begin(Prohibit modification and deletion)
type UF struct {
	parent []int
	size   int
}

func NewUF(n int) *UF {
	p := make([]int, n)
	for i := 0; i < n; i++ {
		p[i] = i
	}
	return &UF{
		parent: p,
		size:   n,
	}
}
func (uf *UF) find(p int) int {
	if uf.parent[p] != p {
		uf.parent[p] = uf.find(uf.parent[p])
	}
	return uf.parent[p]
}
func (uf *UF) union(p, q int) {
	rp, rq := uf.find(p), uf.find(q)
	if rp == rq {
		return
	}
	uf.parent[rp] = rq
}
func (uf *UF) connected(p, q int) bool {
	rp, rq := uf.find(p), uf.find(q)
	return rp == rq
}
func minCostConnectPoints(points [][]int) int {
	n := len(points)
	uf := NewUF(n)
	Abs := func(x int) int {
		if x < 0 {
			return -x
		}
		return x
	}
	var edges [][]int
	for i := 0; i < n; i++ {
		for j := i + 1; j < n; j++ {
			x0, y0, x1, y1 := points[i][0], points[i][1], points[j][0], points[j][1]
			edges = append(edges, []int{i, j, Abs(x0-x1) + Abs(y0-y1)})
		}
	}
	sort.Slice(edges, func(i, j int) bool {
		return edges[i][2] < edges[j][2]
	})
	var cost int
	for _, edge := range edges {
		i, j, w := edge[0], edge[1], edge[2]
		if uf.connected(i, j) {
			continue
		}
		cost += w
		uf.union(i, j)
	}
	return cost
}

//leetcode submit region end(Prohibit modification and deletion)
