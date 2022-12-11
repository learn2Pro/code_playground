package lc

import "math"

//leetcode submit region begin(Prohibit modification and deletion)
func coinChange(coins []int, amount int) int {
	Min := func(x, y int) int {
		if x > y {
			return y
		}
		return x
	}
	dp := make([]int, amount+1)
	dp[0] = 0
	for i := 1; i < amount+1; i++ {
		dp[i] = math.MaxInt32
	}
	for _, coin := range coins {
		for j := coin; j < amount+1; j++ {
			dp[j] = Min(dp[j], dp[j-coin]+1)
		}
	}
	if dp[amount] == math.MaxInt32 {
		return -1
	}
	return dp[amount]
}

//leetcode submit region end(Prohibit modification and deletion)
