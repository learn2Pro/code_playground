package medium

import "math"

func maxProfit(prices []int) int {
	//dp[i][k][0] = Max(dp[i-1][k][0],dp[i-1][k][1]+price)
	//dp[i][k][1] = Max(dp[i-1][k][1],dp[i-2][k-1][0]-price)
	//k is infinite
	Max := func(x, y int) int {
		if x > y {
			return x
		}
		return y
	}
	n := len(prices)
	dp_i_0, dp_i2_0, dp_i_1 := 0, 0, math.MinInt32
	for i := 0; i < n; i++ {
		dp_i2_0, dp_i_0, dp_i_1 = dp_i_0, Max(dp_i_0, dp_i_1+prices[i]), Max(dp_i_1, dp_i2_0-prices[i])
	}
	return dp_i_0
}
