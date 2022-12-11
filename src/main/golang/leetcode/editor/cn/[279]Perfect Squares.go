package lc

import "math"

//leetcode submit region begin(Prohibit modification and deletion)
func numSquares(n int) int {
	Min := func(x, y int) int {
		if x > y {
			return y
		}
		return x
	}
	dp := make([]int, n+1)
	for i := 0; i < n+1; i++ {
		dp[i] = math.MaxInt32
	}
	dp[0] = 0
	for i := 1; i <= 100; i++ {
		for j := i * i; j <= n; j++ {
			dp[j] = Min(dp[j], dp[j-i*i]+1)
		}
	}
	return dp[n]
}

//leetcode submit region end(Prohibit modification and deletion)
