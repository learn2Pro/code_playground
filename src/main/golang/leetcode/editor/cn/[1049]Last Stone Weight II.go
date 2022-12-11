package lc

//leetcode submit region begin(Prohibit modification and deletion)
func lastStoneWeightII(stones []int) int {
	Max := func(x, y int) int {
		if x > y {
			return x
		}
		return y
	}
	var sum int
	for _, stone := range stones {
		sum += stone
	}
	var w = sum / 2
	dp := make([]int, w+1)
	for _, stone := range stones {
		for j := w; j >= stone; j-- {
			dp[j] = Max(dp[j], dp[j-stone]+stone)
		}
	}
	return sum - 2*dp[w]
}

//leetcode submit region end(Prohibit modification and deletion)
