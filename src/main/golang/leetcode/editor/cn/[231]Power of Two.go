package lc

//leetcode submit region begin(Prohibit modification and deletion)
func isPowerOfTwo(n int) bool {
	return n > 0 && n&(n-1) == 0
}

//leetcode submit region end(Prohibit modification and deletion)
