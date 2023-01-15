package lc

//leetcode submit region begin(Prohibit modification and deletion)
func missingNumber(nums []int) (res int) {
	n := len(nums)
	res ^= n
	for i, num := range nums {
		res ^= i ^ num
	}
	return
}

//leetcode submit region end(Prohibit modification and deletion)
