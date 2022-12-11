package lc

//leetcode submit region begin(Prohibit modification and deletion)
func numDistinct(s string, t string) int {
	m, n := len(t), len(s)
	if m > n {
		return 0
	}
	dp := make([][]int, m+1)
	dp[0] = make([]int, n+1)
	for j := 0; j <= n; j++ {
		dp[0][j] = 1
	}
	for i := 1; i <= m; i++ {
		dp[i] = make([]int, n+1)
		for j := 1; j <= n; j++ {
			dp[i][j] += dp[i][j-1]
			if s[j-1] == t[i-1] {
				dp[i][j] += dp[i-1][j-1]
			}
		}
	}
	return dp[m][n]
}

//leetcode submit region end(Prohibit modification and deletion)
