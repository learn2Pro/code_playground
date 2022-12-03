package lc

//leetcode submit region begin(Prohibit modification and deletion)
func allPathsSourceTarget(graph [][]int) (ans [][]int) {
	n := len(graph)
	var path []int
	var traverse func(start int)
	traverse = func(start int) {
		defer func() { path = path[:len(path)-1] }()
		path = append(path, start)
		if start == n-1 {
			var res = make([]int, len(path))
			copy(res, path)
			ans = append(ans, res)
			return
		}
		for _, end := range graph[start] {
			traverse(end)
		}
	}
	traverse(0)
	return
}

//leetcode submit region end(Prohibit modification and deletion)
