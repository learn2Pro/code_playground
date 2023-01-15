package lc

//leetcode submit region begin(Prohibit modification and deletion)
func jump(nums []int) int {
	Max := func(x, y int) int {
		if x > y {
			return x
		}
		return y
	}
	var jumps, end, farthest int
	n := len(nums)
	for i := 0; i < n-1; i++ {
		farthest = Max(farthest, i+nums[i])
		if end == i {
			jumps++
			end = farthest
		}
	}
	return jumps

}

//leetcode submit region end(Prohibit modification and deletion)
