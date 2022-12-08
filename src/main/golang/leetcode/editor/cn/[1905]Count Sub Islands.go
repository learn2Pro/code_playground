package lc

//leetcode submit region begin(Prohibit modification and deletion)
func countSubIslands(grid1 [][]int, grid2 [][]int) (res int) {
	m, n := len(grid1), len(grid1[0])
	var dfs func(i, j int)
	dfs = func(i, j int) {
		if i < 0 || j < 0 || i >= m || j >= n {
			return
		}
		if grid2[i][j] == 0 {
			return
		}
		grid2[i][j] = 0
		dfs(i+1, j)
		dfs(i-1, j)
		dfs(i, j+1)
		dfs(i, j-1)
	}
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if grid1[i][j] == 0 && grid2[i][j] == 1 {
				dfs(i, j)
			}
		}
	}
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if grid2[i][j] == 1 {
				res += 1
				dfs(i, j)
			}
		}
	}
	return
}

//leetcode submit region end(Prohibit modification and deletion)
