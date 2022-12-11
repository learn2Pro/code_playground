package lc

//leetcode submit region begin(Prohibit modification and deletion)
func maxResult(nums []int, k int) int {
	//n := len(nums)
	//dp := make([]int, n)
	//dp[0] = nums[0]
	//var q = []int{0}
	//for i := 1; i < n; i++ {
	//	for len(q) > 0 && i-q[0] > k {
	//		q = q[1:]
	//	}
	//	dp[i] = dp[q[0]] + nums[i]
	//	for len(q) > 0 && dp[i] >= dp[q[len(q)-1]] {
	//		q = q[:len(q)-1]
	//	}
	//	q = append(q, i)
	//}
	//return dp[n-1]

	n := len(nums)
	dp := make([]int, n)
	dp[0] = nums[0]
	var q = []int{0}
	for i := 1; i < n; i++ {
		for len(q) > 0 && i-q[0] > k {
			q = q[1:]
		}
		dp[i] = dp[q[0]] + nums[i]
		for len(q) > 0 && dp[i] >= dp[q[len(q)-1]] {
			q = q[:len(q)-1]
		}
		q = append(q, i)
	}
	return dp[n-1]
}

//leetcode submit region end(Prohibit modification and deletion)
