package lc

//leetcode submit region begin(Prohibit modification and deletion)
func climbStairs(n int) int {
	n0, n1 := 1, 1
	for i := 2; i <= n; i++ {
		n0, n1 = n1, n0+n1
	}
	return n1
}

//leetcode submit region end(Prohibit modification and deletion)
