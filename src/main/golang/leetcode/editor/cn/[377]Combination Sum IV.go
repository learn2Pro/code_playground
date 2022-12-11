package lc

//leetcode submit region begin(Prohibit modification and deletion)
func combinationSum4(nums []int, target int) int {
	dp := make([]int, target+1)
	dp[0] = 1
	//for _, num := range nums {
	//	for i := num; i < target+1; i++ {
	//		dp[i] += dp[i-num]
	//	}
	//}
	for i := 1; i < target+1; i++ {
		for _, num := range nums {
			if i >= num {
				dp[i] += dp[i-num]
			}
		}
	}
	return dp[target]
}

//leetcode submit region end(Prohibit modification and deletion)
