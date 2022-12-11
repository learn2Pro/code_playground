package lc

//leetcode submit region begin(Prohibit modification and deletion)
func findTargetSumWays(nums []int, target int) int {
	//n, w := len(nums), target
	//cache := make(map[string]int)
	//var dp func(i, w int) int
	//dp = func(i, w int) int {
	//	if i == n {
	//		if w == 0 {
	//			return 1
	//		}
	//		return 0
	//	}
	//	key := strconv.Itoa(i) + "," + strconv.Itoa(w)
	//	if v, ok := cache[key]; ok {
	//		return v
	//	}
	//	val := dp(i+1, w+nums[i]) + dp(i+1, w-nums[i])
	//	cache[key] = val
	//	return val
	//}
	//return dp(0, w)
	var sum int
	for _, num := range nums {
		sum += num
	}
	var diff = sum - target
	if diff < 0 || diff%2 != 0 {
		return 0
	}
	dp := make([]int, diff/2+1)
	dp[0] = 1
	for _, num := range nums {
		for j := diff / 2; j >= num; j-- {
			dp[j] += dp[j-num]
		}
	}
	return dp[diff/2]
}

//leetcode submit region end(Prohibit modification and deletion)
