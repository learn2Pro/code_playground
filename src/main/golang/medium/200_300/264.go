package medium

func nthUglyNumber(n int) int {
	min := func(x, y int) int {
		if x < y {
			return x
		} else {
			return y
		}
	}
	dp := make([]int, n+1)
	dp[1] = 1
	p1, p2, p3 := 1, 1, 1
	for i := 2; i <= n; i++ {
		num := min(min(dp[p1]*2, dp[p2]*3), dp[p3]*5)
		if num == dp[p1]*2 {
			p1++
		}
		if num == dp[p2]*3 {
			p2++
		}
		if num == dp[p3]*5 {
			p3++
		}
		dp[i] = num
	}
	return dp[n]
}
