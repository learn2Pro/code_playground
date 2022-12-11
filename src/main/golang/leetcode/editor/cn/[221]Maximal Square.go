package lc

//leetcode submit region begin(Prohibit modification and deletion)
func maximalSquare(matrix [][]byte) (ans int) {
	Max := func(x, y int) int {
		if x > y {
			return x
		}
		return y
	}
	Min := func(x, y int) int {
		if x > y {
			return y
		}
		return x
	}
	m, n := len(matrix), len(matrix[0])
	dp := make([][]int, m+1)
	dp[0] = make([]int, n+1)
	for i := 1; i <= m; i++ {
		dp[i] = make([]int, n+1)
		for j := 1; j <= n; j++ {
			if matrix[i-1][j-1] == '1' {
				dp[i][j] = 1 + Min(dp[i-1][j-1], Min(dp[i-1][j], dp[i][j-1]))
			}
			ans = Max(ans, dp[i][j]*dp[i][j])
		}
	}
	return
}

//leetcode submit region end(Prohibit modification and deletion)
