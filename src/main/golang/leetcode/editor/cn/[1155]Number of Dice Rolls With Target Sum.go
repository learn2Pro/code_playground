package lc

//leetcode submit region begin(Prohibit modification and deletion)
func numRollsToTarget(n int, k int, target int) int {
	var mod int = 1e9 + 7
	dp := make([][]int, n+1)
	for i := 0; i < n+1; i++ {
		dp[i] = make([]int, target+1)
	}
	dp[0][0] = 1
	for i := 1; i < n+1; i++ {
		for j := 1; j < target+1; j++ {
			for x := 1; x <= k; x++ {
				if j >= x {
					dp[i][j] = (dp[i][j] + dp[i-1][j-x]) % mod
				}
			}
		}
	}
	return dp[n][target]
}

//leetcode submit region end(Prohibit modification and deletion)
