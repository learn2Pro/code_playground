package easy

//fib with dp
func fib(n int) int {
	if n <= 1 {
		return n
	}
	dp := make([]int, n+1)
	dp[0], dp[1] = 0, 1
	for i := 2; i <= n; i++ {
		dp[i] = dp[i-1] + dp[i-2]
	}
	return dp[n]
}

//func fib(n int) int {
//	if n <= 1 {
//		return n
//	}
//	return fib(n-1) + fib(n-2)
//}
