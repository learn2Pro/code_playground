package lc

//leetcode submit region begin(Prohibit modification and deletion)
func numEnclaves(grid [][]int) (res int) {
	//0=water 1=land
	m, n := len(grid), len(grid[0])
	var dfs func(i, j int) int
	dfs = func(i, j int) int {
		if i < 0 || j < 0 || i >= m || j >= n {
			return 0
		}
		if grid[i][j] == 0 {
			return 0
		}
		grid[i][j] = 0
		return 1 +
			dfs(i+1, j) +
			dfs(i-1, j) +
			dfs(i, j+1) +
			dfs(i, j-1)
	}
	for i := 0; i < m; i++ {
		dfs(i, 0)
		dfs(i, n-1)
	}
	for j := 0; j < n; j++ {
		dfs(0, j)
		dfs(m-1, j)
	}
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if grid[i][j] == 1 {
				res += dfs(i, j)
			}
		}
	}
	return
}

//leetcode submit region end(Prohibit modification and deletion)
