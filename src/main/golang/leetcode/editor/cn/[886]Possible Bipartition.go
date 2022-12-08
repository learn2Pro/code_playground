package lc

//leetcode submit region begin(Prohibit modification and deletion)
func possibleBipartition(n int, dislikes [][]int) bool {
	var ok = true
	color, visited := make([]bool, n), make([]bool, n)
	var graph = make([][]int, n)
	for _, tuple := range dislikes {
		graph[tuple[1]-1] = append(graph[tuple[1]-1], tuple[0]-1)
		graph[tuple[0]-1] = append(graph[tuple[0]-1], tuple[1]-1)
	}
	var dfs func(start int)
	dfs = func(start int) {
		if !ok {
			return
		}
		visited[start] = true
		for _, next := range graph[start] {
			if !visited[next] {
				color[next] = !color[start]
				dfs(next)
			} else {
				if color[next] == color[start] {
					ok = false
					return
				}
			}
		}
	}
	for i := 0; i < n && ok; i++ {
		dfs(i)
	}
	return ok
}

//leetcode submit region end(Prohibit modification and deletion)
