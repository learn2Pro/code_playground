package lc

//leetcode submit region begin(Prohibit modification and deletion)
func superEggDrop(k int, n int) int {
	dp := make([][]int, k+1)
	for i := 0; i < k+1; i++ {
		dp[i] = make([]int, n+1)
	}
	var m int
	for dp[k][m] < n {
		m++
		for i := 1; i <= k; i++ {
			dp[i][m] = 1 + dp[i][m-1] + dp[i-1][m-1]
		}
	}
	return m
}

//leetcode submit region end(Prohibit modification and deletion)
