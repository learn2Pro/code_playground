package hard

import "math"

func maxProfit(prices []int) int {
	//dp[i][k][0] = Max(dp[i-1][k][0],dp[i-1][k][1]+price)
	//dp[i][k][1] = Max(dp[i-1][k][1],dp[i-1][k-1][0]-price)
	//k=2
	//dp[i][2][0] = Max(dp[i-1][2][0],dp[i-1][2][1]+price)
	//dp[i][2][1] = Max(dp[i-1][2][1],dp[i-1][1][0]-price)
	//dp[i][1][0] = Max(dp[i-1][1][0],dp[i-1][1][1]+price)
	//dp[i][1][1] = Max(dp[i-1][1][1],dp[i-1][0][0]-price)
	Max := func(x, y int) int {
		if x > y {
			return x
		}
		return y
	}
	dp_i_2_0, dp_i_2_1, dp_i_1_0, dp_i_1_1 := 0, math.MinInt32, 0, math.MinInt32
	for i := 0; i < len(prices); i++ {
		dp_i_2_0, dp_i_2_1, dp_i_1_0, dp_i_1_1 =
			Max(dp_i_2_0, dp_i_2_1+prices[i]),
			Max(dp_i_2_1, dp_i_1_0-prices[i]),
			Max(dp_i_1_0, dp_i_1_1+prices[i]),
			Max(dp_i_1_1, -prices[i])
	}
	return dp_i_2_0
}
