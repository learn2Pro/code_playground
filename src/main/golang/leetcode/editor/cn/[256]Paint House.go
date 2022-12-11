package lc

//leetcode submit region begin(Prohibit modification and deletion)
func minCost(costs [][]int) int {
	Min := func(x, y int) int {
		if x > y {
			return y
		}
		return x
	}
	n := len(costs)
	dp := make([][3]int, n+1)
	dp[0] = [3]int{0, 0, 0}
	for i := 1; i <= n; i++ {
		dp[i][0] = Min(dp[i-1][1], dp[i-1][2]) + costs[i-1][0]
		dp[i][1] = Min(dp[i-1][0], dp[i-1][2]) + costs[i-1][1]
		dp[i][2] = Min(dp[i-1][1], dp[i-1][0]) + costs[i-1][2]
	}
	return Min(Min(dp[n][0], dp[n][1]), dp[n][2])
}

//leetcode submit region end(Prohibit modification and deletion)
