package lc

//leetcode submit region begin(Prohibit modification and deletion)
func constrainedSubsetSum(nums []int, k int) int {
	Max := func(x, y int) int {
		if x > y {
			return x
		}
		return y
	}
	//var queue = []int{0}
	//n := len(nums)
	//var dp = make([]int, n)
	//dp[0] = nums[0]
	//var ans = nums[0] //有可能是负
	//for i := 1; i < n; i++ {
	//	for len(queue) > 0 && i-queue[0] > k {
	//		queue = queue[1:]
	//	}
	//	dp[i] = Max(dp[queue[0]], 0) + nums[i]
	//	ans = Max(ans, dp[i])
	//	for len(queue) > 0 && dp[i] >= dp[queue[len(queue)-1]] {
	//		queue = queue[:len(queue)-1]
	//	}
	//	queue = append(queue, i)
	//}
	//return ans
	n := len(nums)
	dp := make([]int, n)
	dp[0] = nums[0]
	var q = []int{0}
	var ans = nums[0]
	for i := 1; i < n; i++ {
		for len(q) > 0 && i-q[0] > k {
			q = q[1:]
		}
		dp[i] = Max(dp[q[0]], 0) + nums[i]
		ans = Max(ans, dp[i])
		for len(q) > 0 && dp[i] >= dp[q[len(q)-1]] {
			q = q[:len(q)-1]
		}
		q = append(q, i)
	}
	return ans
}

//leetcode submit region end(Prohibit modification and deletion)
