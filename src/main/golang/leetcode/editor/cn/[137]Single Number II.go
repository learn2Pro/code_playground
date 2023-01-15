package lc

//leetcode submit region begin(Prohibit modification and deletion)
func singleNumber(nums []int) int {
	var ans int32
	for i := 0; i < 32; i++ {
		var total int
		for _, num := range nums {
			total += (num >> i) & 1
		}
		if total%3 > 0 {
			ans |= 1 << i
		}
	}
	return int(ans)
}

//leetcode submit region end(Prohibit modification and deletion)
