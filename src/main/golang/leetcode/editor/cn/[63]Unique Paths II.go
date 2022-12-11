package lc

//leetcode submit region begin(Prohibit modification and deletion)
func uniquePathsWithObstacles(obstacleGrid [][]int) (ans int) {
	//m, n := len(obstacleGrid), len(obstacleGrid[0])
	//var dfs func(i, j int)
	//dfs = func(i, j int) {
	//	if i == m-1 && j == n-1 {
	//		ans += 1
	//		return
	//	}
	//	if i >= m || j >= n || obstacleGrid[i][j] == 1 {
	//		return
	//	}
	//	dfs(i+1, j)
	//	dfs(i, j+1)
	//}
	//if obstacleGrid[m-1][n-1] == 1 {
	//	return 0
	//}
	//dfs(0, 0)
	//return
	m, n := len(obstacleGrid), len(obstacleGrid[0])
	//if obstacleGrid[m-1][n-1] == 1 || obstacleGrid[0][0] == 1 {
	//	return 0
	//}
	//dp := make([][]int, m+1)
	//dp[0] = make([]int, n+1)
	//for i := 1; i <= m; i++ {
	//	dp[i] = make([]int, n+1)
	//	for j := 1; j <= n; j++ {
	//		if i == 1 && j == 1 {
	//			dp[i][j] = 1
	//		} else if obstacleGrid[i-1][j-1] == 0 {
	//			dp[i][j] = dp[i-1][j] + dp[i][j-1]
	//		}
	//	}
	//}
	//return dp[m][n]
	dp := make([]int, n)
	if obstacleGrid[0][0] == 0 {
		dp[0] = 1
	}
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if obstacleGrid[i][j] == 1 {
				dp[j] = 0
			} else {
				if j-1 >= 0 && obstacleGrid[i][j] == 0 {
					dp[j] += dp[j-1]
				}
			}
		}
	}
	return dp[n-1]
}

//leetcode submit region end(Prohibit modification and deletion)
