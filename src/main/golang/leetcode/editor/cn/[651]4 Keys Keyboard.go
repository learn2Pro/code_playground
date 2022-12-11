package lc

//leetcode submit region begin(Prohibit modification and deletion)
func maxA(n int) int {
	Max := func(x, y int) int {
		if x > y {
			return x
		}
		return y
	}
	dp := make([]int, n+1)
	for i := 1; i <= n; i++ {
		dp[i] = dp[i-1] + 1
		for k := 0; k < i-1; k++ {
			dp[i] = Max(dp[i], dp[k]*(i-k-1))
		}
	}
	return dp[n]
}

//leetcode submit region end(Prohibit modification and deletion)
