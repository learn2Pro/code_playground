package lc

//leetcode submit region begin(Prohibit modification and deletion)
func hammingWeight(num uint32) (ans int) {
	for num != 0 {
		num &= (num - 1)
		ans += 1
	}
	return
}

//leetcode submit region end(Prohibit modification and deletion)
