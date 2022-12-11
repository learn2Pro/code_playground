package lc

//leetcode submit region begin(Prohibit modification and deletion)
func canPartition(nums []int) bool {
	//var sum int
	//for _, num := range nums {
	//	sum += num
	//}
	//if sum%2 != 0 {
	//	return false
	//}
	//n := len(nums)
	//w := sum / 2
	//dp := make([][]bool, n+1)
	//for i := 0; i < n+1; i++ {
	//	dp[i] = make([]bool, w+1)
	//	dp[i][0] = true //装满0weight的背包
	//}
	//for i := 1; i < n+1; i++ {
	//	for j := 1; j < w+1; j++ {
	//		if nums[i-1] > j {
	//			dp[i][j] = dp[i-1][j]
	//		} else {
	//			dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]]
	//		}
	//	}
	//}
	//return dp[n][w]
	var sum int
	for _, num := range nums {
		sum += num
	}
	if sum%2 != 0 {
		return false
	}
	var target = sum / 2
	dp := make([]bool, target+1)
	dp[0] = true
	for _, num := range nums {
		for i := target; i >= num; i-- {
			dp[i] = dp[i] || dp[i-num]
		}
	}
	return dp[target]
}

//leetcode submit region end(Prohibit modification and deletion)
