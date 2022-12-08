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
func (uf *UF) union(p, q int) {
	rp, rq := uf.find(p), uf.find(q)
	if rp == rq {
		return
	}
	uf.parent[rp] = rq
	uf.size -= 1
}
func (uf *UF) find(p int) int {
	if uf.parent[p] != p {
		uf.parent[p] = uf.find(uf.parent[p])
	}
	return uf.parent[p]
}
func (uf *UF) connected(p, q int) bool {
	rp, rq := uf.find(p), uf.find(q)
	return rp == rq
}

func minimumCost(n int, connections [][]int) int {
	var cost int
	var uf = NewUF(n)
	sort.Slice(connections, func(i, j int) bool {
		return connections[i][2] < connections[j][2]
	})
	for _, conn := range connections {
		p, q, w := conn[0]-1, conn[1]-1, conn[2]
		if uf.connected(p, q) {
			continue
		}
		cost += w
		uf.union(p, q)
	}
	if uf.size == 1 {
		return cost
	}
	return -1
}

//leetcode submit region end(Prohibit modification and deletion)
