package lc

//leetcode submit region begin(Prohibit modification and deletion)
func isMatch(s string, p string) bool {
	m, n := len(s), len(p)
	dp := make([][]bool, m+1)
	for i := 0; i <= m; i++ {
		dp[i] = make([]bool, n+1)
	}
	dp[0][0] = true
	matches := func(i, j int) bool {
		if i == 0 {
			return false
		}
		return s[i-1] == p[j-1] || p[j-1] == '.'
	}
	for i := 0; i <= m; i++ {
		for j := 1; j <= n; j++ {
			if p[j-1] == '*' {
				if matches(i, j-1) {
					dp[i][j] = dp[i][j] || dp[i-1][j] || dp[i][j-2]
				} else {
					dp[i][j] = dp[i][j] || dp[i][j-2]
				}
			} else {
				if matches(i, j) {
					dp[i][j] = dp[i][j] || dp[i-1][j-1]
				} else {
					dp[i][j] = false
				}
			}
		}
	}
	return dp[m][n]
}

//leetcode submit region end(Prohibit modification and deletion)
