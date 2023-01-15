package lc

//leetcode submit region begin(Prohibit modification and deletion)
func singleNumber(nums []int) (ans int) {
	for _, num := range nums {
		ans ^= num
	}
	return
}

//leetcode submit region end(Prohibit modification and deletion)
