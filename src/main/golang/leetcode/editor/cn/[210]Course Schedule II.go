package lc

//leetcode submit region begin(Prohibit modification and deletion)
func findOrder(numCourses int, prerequisites [][]int) []int {
	//var postorder []int
	//visited := make([]bool, numCourses)
	//path := make([]bool, numCourses)
	//var hasCycle bool
	//var graph = make([][]int, numCourses)
	//for _, tuple := range prerequisites {
	//	graph[tuple[1]] = append(graph[tuple[1]], tuple[0])
	//}
	//var dfs func(start int)
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
	//	postorder = append(postorder, start)
	//	path[start] = false
	//}
	//for i := 0; i < numCourses; i++ {
	//	dfs(i)
	//}
	//if hasCycle {
	//	return []int{}
	//}
	//for i, j := 0, numCourses-1; i < j; i, j = i+1, j-1 {
	//	postorder[i], postorder[j] = postorder[j], postorder[i]
	//}
	//return postorder
	//topo sort
	var queue []int
	var graph = make([][]int, numCourses)
	var indegree = make([]int, numCourses)
	for _, tuple := range prerequisites {
		graph[tuple[1]] = append(graph[tuple[1]], tuple[0])
		indegree[tuple[0]]++
	}
	for i := 0; i < numCourses; i++ {
		if indegree[i] == 0 {
			queue = append(queue, i)
		}
	}
	var path []int
	for len(queue) > 0 {
		curr := queue[0]
		queue = queue[1:]
		path = append(path, curr)
		for _, next := range graph[curr] {
			indegree[next]--
			if indegree[next] == 0 {
				queue = append(queue, next)
			}
		}
	}
	if len(path) != numCourses {
		return []int{}
	}
	return path
}

//leetcode submit region end(Prohibit modification and deletion)
