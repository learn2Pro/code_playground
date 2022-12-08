package lc

//leetcode submit region begin(Prohibit modification and deletion)
func equationsPossible(equations []string) bool {
	parent := make([]int, 26)
	for i := 0; i < 26; i++ {
		parent[i] = i
	}
	var find func(p int) int
	var union func(p, q int)
	var connected func(p, q int) bool
	find = func(p int) int {
		if parent[p] != p {
			parent[p] = find(parent[p])
		}
		return parent[p]
	}
	union = func(p, q int) {
		rootp, rootq := find(p), find(q)
		if rootp == rootq {
			return
		}
		parent[rootp] = rootq
	}
	connected = func(p, q int) bool {
		rootp, rootq := find(p), find(q)
		return rootp == rootq
	}
	for _, equation := range equations {
		if equation[1] == '=' {
			a, b := equation[0], equation[3]
			union(int(a-'a'), int(b-'a'))
		}
	}
	for _, equation := range equations {
		if equation[1] == '!' {
			a, b := equation[0], equation[3]
			if connected(int(a-'a'), int(b-'a')) {
				return false
			}
		}
	}
	return true
}

//leetcode submit region end(Prohibit modification and deletion)
