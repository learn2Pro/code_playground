package lc

//leetcode submit region begin(Prohibit modification and deletion)
func countHighestScoreNodes(parents []int) int {
	n := len(parents)
	var children = make([][]int, n)
	for i := 0; i < n; i++ {
		parent := parents[i]
		if parent != -1 {
			children[parent] = append(children[parent], i)
		}
	}
	maximal, cnt := 0, 0
	var dfs func(index int) int
	dfs = func(index int) int {
		score, size := 1, n-1
		for _, child := range children[index] {
			sz := dfs(child)
			score *= sz
			size -= sz
		}
		if size != 0 {
			score *= size
		}
		if score == maximal {
			cnt += 1
		} else if score > maximal {
			maximal, cnt = score, 1
		}
		return n - size
	}
	dfs(0)
	return cnt
}

//leetcode submit region end(Prohibit modification and deletion)
