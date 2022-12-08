package lc

//leetcode submit region begin(Prohibit modification and deletion)
func validateBinaryTreeNodes(n int, leftChild []int, rightChild []int) bool {
	indegree := make([]int, n)
	for _, to := range leftChild {
		if to != -1 {
			indegree[to]++
		}

	}
	for _, to := range rightChild {
		if to != -1 {
			indegree[to]++
		}
	}
	var root = -1
	for i := 0; i < n; i++ {
		if indegree[i] == 0 {
			root = i
			break
		}
	}
	if root == -1 {
		return false
	}
	queue := []int{root}
	var cnt int
	visited := make([]bool, n)
	for len(queue) > 0 {
		curr := queue[0]
		queue = queue[1:]
		if visited[curr] {
			return false
		}
		visited[curr] = true
		cnt += 1
		if leftChild[curr] != -1 {
			queue = append(queue, leftChild[curr])
		}
		if rightChild[curr] != -1 {
			queue = append(queue, rightChild[curr])
		}
	}
	return cnt == n
}

//leetcode submit region end(Prohibit modification and deletion)
