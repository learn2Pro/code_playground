package medium

import "math"

func maxResult(nums []int, k int) int {
	//Max := func(x, y int) int {
	//	if x > y {
	//		return x
	//	}
	//	return y
	//}
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

	Max := func(x, y int) int {
		if x > y {
			return x
		}
		return y
	}
	n := len(nums)
	dp := make([]int, n)
	dp[0] = nums[0]
	for i := 1; i < n; i++ {
		dp[i] = math.MinInt32
		for j := i - k; j <= i-1; j++ {
			if j < 0 {
				continue
			}
			dp[i] = Max(dp[i], dp[j]+nums[i])
		}
	}
	return dp[n-1]
}
