package medium

import "math"

func maxProfit(prices []int, fee int) int {
	//dp[i][k][0] = Max(dp[i-1][k][0],dp[i-1][k][1]+price-fee)
	//dp[i][k][1] = Max(dp[i-1][k][1],dp[i-1][k-1][0]-price)
	//k is infinite
	Max := func(x, y int) int {
		if x > y {
			return x
		}
		return y
	}
	dp_i_0, dp_i_1 := 0, math.MinInt32
	for i := 0; i < len(prices); i++ {
		dp_i_0, dp_i_1 = Max(dp_i_0, dp_i_1+prices[i]-fee), Max(dp_i_1, dp_i_0-prices[i])
	}
	return dp_i_0
}
