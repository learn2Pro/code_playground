package lc

//leetcode submit region begin(Prohibit modification and deletion)
func minPathSum(grid [][]int) int {
	Min := func(x, y int) int {
		if x > y {
			return y
		}
		return x
	}
	m, n := len(grid), len(grid[0])
	//dp := make([][]int, m+1)
	//for i := 0; i < m+1; i++ {
	//	dp[i] = make([]int, n+1)
	//	dp[i][0] = math.MaxInt32
	//}
	//for j := 0; j < n+1; j++ {
	//	dp[0][j] = math.MaxInt32
	//}
	//dp[0][1] = 0
	//for i := 1; i < m+1; i++ {
	//	for j := 1; j < n+1; j++ {
	//		dp[i][j] = Min(dp[i-1][j], dp[i][j-1]) + grid[i-1][j-1]
	//	}
	//}
	//return dp[m][n]
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if i == j && i == 0 {
				continue
			} else if i == 0 {
				grid[i][j] += grid[i][j-1]
			} else if j == 0 {
				grid[i][j] += grid[i-1][j]
			} else {
				grid[i][j] += Min(grid[i-1][j], grid[i][j-1])
			}
		}
	}
	return grid[m-1][n-1]
}

//leetcode submit region end(Prohibit modification and deletion)
