package lc

//leetcode submit region begin(Prohibit modification and deletion)
func trailingZeroes(n int) (ans int) {
	for n > 0 {
		n /= 5
		ans += n
	}
	return
}

//leetcode submit region end(Prohibit modification and deletion)
