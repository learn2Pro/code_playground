package lc

//leetcode submit region begin(Prohibit modification and deletion)
func change(amount int, coins []int) int {
	dp := make([]int, amount+1)
	dp[0] = 1
	for _, coin := range coins {
		for i := coin; i < amount+1; i++ {
			if i >= coin {
				dp[i] += dp[i-coin]
			}
		}
	}
	return dp[amount]
}

//leetcode submit region end(Prohibit modification and deletion)
