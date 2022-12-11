package lc

//leetcode submit region begin(Prohibit modification and deletion)
func minDistance(word1 string, word2 string) int {
	Min := func(x, y int) int {
		if x > y {
			return y
		}
		return x
	}
	m, n := len(word1), len(word2)
	dp := make([][]int, m+1)
	for i := 0; i <= m; i++ {
		dp[i] = make([]int, n+1)
		dp[i][0] = i
	}
	for j := 0; j <= n; j++ {
		dp[0][j] = j
	}
	for i := 1; i <= m; i++ {
		for j := 1; j <= n; j++ {
			if word1[i-1] == word2[j-1] {
				dp[i][j] = dp[i-1][j-1]
			} else {
				dp[i][j] = Min(Min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1]) + 1
			}
		}
	}
	return dp[m][n]
}

//leetcode submit region end(Prohibit modification and deletion)
