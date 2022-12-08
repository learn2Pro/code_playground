package lc

//leetcode submit region begin(Prohibit modification and deletion)
func maxAreaOfIsland(grid [][]int) int {

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
	var res int
	for k := 0; k < m; k++ {
		for l := 0; l < n; l++ {
			if grid[k][l] == 1 {
				num := dfs(k, l)
				if num > res {
					res = num
				}
			}
		}
	}
	return res
}

//leetcode submit region end(Prohibit modification and deletion)
