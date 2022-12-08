package lc

//leetcode submit region begin(Prohibit modification and deletion)
func canFinish(numCourses int, prerequisites [][]int) bool {
	//dfs
	//var graph = make([][]int, numCourses)
	//for _, tuple := range prerequisites {
	//	graph[tuple[1]] = append(graph[tuple[1]], tuple[0])
	//}
	//visited := make([]bool, numCourses)
	//path := make([]bool, numCourses)
	//var dfs func(start int)
	//var hasCycle bool
	//dfs = func(start int) {
	//	if path[start] {
	//		hasCycle = true
	//	}
	//	if visited[start] || hasCycle {
	//		return
	//	}
	//	visited[start] = true
	//	path[start] = true
	//	for _, next := range graph[start] {
	//		dfs(next)
	//	}
	//	path[start] = false
	//}
	//for i := 0; i < numCourses; i++ {
	//	dfs(i)
	//}
	//return !hasCycle
	//topo traversal
	var queue []int
	var graph = make([][]int, numCourses)
	indegree := make([]int, numCourses)
	for _, tuple := range prerequisites {
		from, to := tuple[1], tuple[0]
		indegree[to] += 1
		graph[from] = append(graph[from], to)
	}
	for i := 0; i < numCourses; i++ {
		if indegree[i] == 0 {
			queue = append(queue, i)
		}
	}
	var cnt int
	for len(queue) > 0 {
		curr := queue[0]
		queue = queue[1:]
		cnt += 1
		for _, next := range graph[curr] {
			indegree[next] -= 1
			if indegree[next] == 0 {
				queue = append(queue, next)
			}
		}
	}
	return cnt == numCourses
}

//leetcode submit region end(Prohibit modification and deletion)
