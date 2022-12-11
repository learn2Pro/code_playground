package lc

//leetcode submit region begin(Prohibit modification and deletion)
func PredictTheWinner(nums []int) bool {
	n := len(nums)
	dp := make([][][2]int, n)
	for i := 0; i < n; i++ {
		dp[i] = make([][2]int, n)
		dp[i][i] = [2]int{nums[i], 0}
	}
	for i := n - 1; i >= 0; i-- {
		for j := i + 1; j < n; j++ {
			s0, s1 := dp[i+1][j][1]+nums[i], dp[i][j-1][1]+nums[j]
			if s0 > s1 {
				dp[i][j][0], dp[i][j][1] = s0, dp[i+1][j][0]
			} else {
				dp[i][j][0], dp[i][j][1] = s1, dp[i][j-1][0]
			}
		}
	}
	return dp[0][n-1][0]-dp[0][n-1][1] >= 0
}

//leetcode submit region end(Prohibit modification and deletion)
