package lc

//leetcode submit region begin(Prohibit modification and deletion)
func longestPalindromeSubseq(s string) int {
	Min := func(x, y int) int {
		if x > y {
			return y
		}
		return x
	}
	n := len(s)
	dp := make([][]int, n)
	for i := 0; i < n; i++ {
		dp[i] = make([]int, n)
	}
	for span := 2; span <= n; span++ {
		for i := 0; i <= n-span; i++ {
			j := i + span - 1
			if s[i] == s[j] {
				dp[i][j] = dp[i+1][j-1]
			} else {
				dp[i][j] = Min(dp[i+1][j], dp[i][j-1]) + 1
			}
		}
	}
	return n - dp[0][n-1]
}

//leetcode submit region end(Prohibit modification and deletion)
