package lc

//leetcode submit region begin(Prohibit modification and deletion)
func numTrees(n int) int {
	//var memo = make([]int, 20)
	//memo[0], memo[1] = 1, 1
	//var counter func(x int) int
	//counter = func(x int) int {
	//	if memo[x] > 0 {
	//		return memo[x]
	//	}
	//	var cnt int
	//	for i := 1; i <= x; i++ {
	//		cnt += counter(i-1) * counter(x-i)
	//	}
	//	memo[x] = cnt
	//	return cnt
	//}
	//return counter(n)
	var dp = make([]int, n+1)
	dp[0], dp[1] = 1, 1
	for i := 2; i <= n; i++ {
		for j := 1; j <= i; j++ {
			dp[i] += dp[j-1] * dp[i-j]
		}
	}
	return dp[n]
}

//leetcode submit region end(Prohibit modification and deletion)
