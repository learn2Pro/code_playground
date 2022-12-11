package lc

//leetcode submit region begin(Prohibit modification and deletion)
func minInsertions(s string) int {
	//Max := func(x, y int) int {
	//	if x > y {
	//		return x
	//	}
	//	return y
	//}
	//Reverse := func(s string) string {
	//	runes := []rune(s)
	//	for i, j := 0, len(runes)-1; i < j; i, j = i+1, j-1 {
	//		runes[i], runes[j] = runes[j], runes[i]
	//	}
	//	return string(runes)
	//}
	//n := len(s)
	//dp := make([][]int, n+1)
	//dp[0] = make([]int, n+1)
	//t := Reverse(s)
	//for i := 1; i < n+1; i++ {
	//	dp[i] = make([]int, n+1)
	//	for j := 1; j < n+1; j++ {
	//		if s[i-1] == t[j-1] {
	//			dp[i][j] = dp[i-1][j-1] + 1
	//		} else {
	//			dp[i][j] = Max(dp[i-1][j], dp[i][j-1])
	//		}
	//	}
	//}
	//return n - dp[n][n]
	n := len(s)
	Min := func(x, y int) int {
		if x > y {
			return y
		}
		return x
	}
	dp := make([][]int, n)
	for i := 0; i < n; i++ {
		dp[i] = make([]int, n)
	}
	for span := 2; span <= n; span++ {
		for i := 0; i <= n-span; i++ {
			var j = i + span - 1
			if s[i] == s[j] {
				dp[i][j] = dp[i+1][j-1]
			} else {
				dp[i][j] = Min(dp[i+1][j], dp[i][j-1]) + 1
			}
		}
	}
	return dp[0][n-1]
}

//leetcode submit region end(Prohibit modification and deletion)
