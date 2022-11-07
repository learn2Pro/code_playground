package medium

import "math"

//coinChange with dp
func coinChange(coins []int, amount int) int {
	min := func(x, y int) int {
		if x < y {
			return x
		} else {
			return y
		}
	}
	dp := make([]int, amount+1)
	for i := 1; i < amount+1; i++ {
		dp[i] = math.MaxInt32
		for _, coin := range coins {
			if i-coin < 0 {
				continue
			}
			dp[i] = min(dp[i], 1+dp[i-coin])
		}
	}
	if dp[amount] == math.MaxInt32 {
		return -1
	}
	return dp[amount]
}
