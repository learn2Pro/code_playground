package lc

//leetcode submit region begin(Prohibit modification and deletion)
func numDecodings(s string) int {
	n := len(s)
	dp := make([]int, n+1)
	dp[0] = 1
	if s[0] != '0' {
		dp[1] = 1
	}
	for i := 2; i <= n; i++ {
		c1, c2 := s[i-1], s[i-2]
		if c1 >= '1' && c1 <= '9' {
			dp[i] += dp[i-1]
		}
		if c2 == '1' || (c2 == '2' && c1 <= '6') {
			dp[i] += dp[i-2]
		}
	}
	return dp[n]
}

//leetcode submit region end(Prohibit modification and deletion)
