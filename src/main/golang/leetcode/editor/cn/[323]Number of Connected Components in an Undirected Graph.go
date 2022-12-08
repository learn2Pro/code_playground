package lc

//leetcode submit region begin(Prohibit modification and deletion)
func countComponents(n int, edges [][]int) int {
	var parent = make([]int, n)
	for i := 0; i < n; i++ {
		parent[i] = i
	}
	var union func(p, q int)
	var find func(p int) int
	find = func(p int) int {
		if parent[p] != p {
			parent[p] = find(parent[p])
		}
		return parent[p]
	}
	union = func(p, q int) {
		rootp, rootq := find(p), find(q)
		if rootq == rootp {
			return
		}
		parent[rootp] = rootq
		n--
	}
	for _, edge := range edges {
		union(edge[0], edge[1])
	}
	return n
}

//leetcode submit region end(Prohibit modification and deletion)
