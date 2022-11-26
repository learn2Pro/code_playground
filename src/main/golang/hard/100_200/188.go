package hard

import "math"

func maxProfit1(k int, prices []int) int {
	//dp[i][k][0] = Max(dp[i-1][k][0],dp[i-1][k][1]+price)
	//dp[i][k][1] = Max(dp[i-1][k][1],dp[i-1][k-1][0]-price)
	//k is variable
	Max := func(x, y int) int {
		if x > y {
			return x
		}
		return y
	}
	n := len(prices)
	var dp = make([][][]int, n)
	for i := 0; i < n; i++ {
		dp[i] = make([][]int, k+1)
		for j := 0; j <= k; j++ {
			dp[i][j] = make([]int, 2)
			dp[i][j][0] = 0
			dp[i][j][1] = math.MinInt32
		}
	}
	for i, price := range prices {
		for j := k; j >= 1; j-- {
			if i-1 < 0 {
				dp[i][j][0] = 0
				dp[i][j][1] = -prices[i]
				continue
			}
			dp[i][j][0] = Max(dp[i-1][j][0], dp[i-1][j][1]+price)
			dp[i][j][1] = Max(dp[i-1][j][1], dp[i-1][j-1][0]-price)
		}
	}
	return dp[n-1][k][0]
}
