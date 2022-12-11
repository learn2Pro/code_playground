package lc

//leetcode submit region begin(Prohibit modification and deletion)
func lengthOfLIS(nums []int) (ans int) {
	//Max := func(x, y int) int {
	//	if x > y {
	//		return x
	//	}
	//	return y
	//}
	//n := len(nums)
	//dp := make([]int, n)
	//for i := 0; i < n; i++ {
	//	dp[i] = 1
	//	for j := 0; j < i; j++ {
	//		if nums[i] > nums[j] {
	//			dp[i] = Max(dp[i], dp[j]+1)
	//		}
	//	}
	//	ans = Max(ans, dp[i])
	//}
	//return
	n := len(nums)
	top := make([]int, n)
	var piles int
	for _, num := range nums {
		l, r := 0, piles
		for l < r {
			mid := l + (r-l)/2
			if top[mid] < num {
				l = mid + 1
			} else {
				r = mid
			}
		}
		if l == piles {
			piles++
		}
		top[l] = num
	}
	return piles
}

//leetcode submit region end(Prohibit modification and deletion)
