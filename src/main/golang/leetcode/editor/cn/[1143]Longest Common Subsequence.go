package lc

//leetcode submit region begin(Prohibit modification and deletion)
func longestCommonSubsequence(text1 string, text2 string) int {
	Max := func(x, y int) int {
		if x > y {
			return x
		}
		return y
	}
	m, n := len(text1), len(text2)
	var dp = make([][]int, m+1)
	dp[0] = make([]int, n+1)
	for i := 1; i <= m; i++ {
		dp[i] = make([]int, n+1)
		for j := 1; j <= n; j++ {
			if text1[i-1] == text2[j-1] {
				dp[i][j] = dp[i-1][j-1] + 1
			} else {
				dp[i][j] = Max(dp[i-1][j], dp[i][j-1])
			}
		}
	}
	return dp[m][n]
}

//leetcode submit region end(Prohibit modification and deletion)
