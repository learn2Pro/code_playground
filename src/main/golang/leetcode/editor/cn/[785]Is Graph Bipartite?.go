package lc

//leetcode submit region begin(Prohibit modification and deletion)
func isBipartite(graph [][]int) bool {
	//dfs
	//var notBipartite bool
	//n := len(graph)
	//color, visited := make([]bool, n), make([]bool, n)
	//var dfs func(start int)
	//dfs = func(start int) {
	//	if notBipartite {
	//		return
	//	}
	//	visited[start] = true
	//	for _, next := range graph[start] {
	//		if !visited[next] {
	//			color[next] = !color[start]
	//			dfs(next)
	//		} else {
	//			if color[next] == color[start] {
	//				notBipartite = true
	//				return
	//			}
	//		}
	//	}
	//}
	//for i := 0; i < n; i++ {
	//	if !notBipartite {
	//		dfs(i)
	//	}
	//}
	//return !notBipartite
	//bfs
	var notBipartite bool
	n := len(graph)
	color, visited := make([]bool, n), make([]bool, n)
	bfs := func(start int) {
		var queue = []int{start}
		for len(queue) > 0 && !notBipartite {
			curr := queue[0]
			queue = queue[1:]
			visited[curr] = true
			for _, next := range graph[curr] {
				if !visited[next] {
					color[next] = !color[curr]
					queue = append(queue, next)
				} else {
					if color[next] == color[curr] {
						notBipartite = true
						return
					}
				}
			}
		}
	}
	for i := 0; i < n; i++ {
		if !visited[i] && !notBipartite {
			bfs(i)
		}
	}
	return !notBipartite
}

//leetcode submit region end(Prohibit modification and deletion)
