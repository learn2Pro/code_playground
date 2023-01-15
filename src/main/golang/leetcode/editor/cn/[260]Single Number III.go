package lc

//leetcode submit region begin(Prohibit modification and deletion)
func singleNumber(nums []int) []int {
	var seed int
	for _, num := range nums {
		seed ^= num
	}
	//sign := (seed & (seed - 1)) ^ seed
	sign := seed & -seed
	var s0, s1 int
	for _, num := range nums {
		if sign&num > 0 {
			s0 ^= num
		} else {
			s1 ^= num
		}
	}
	return []int{s0, s1}
}

//leetcode submit region end(Prohibit modification and deletion)
