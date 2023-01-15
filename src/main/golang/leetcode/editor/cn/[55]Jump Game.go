package lc

//leetcode submit region begin(Prohibit modification and deletion)
func canJump(nums []int) bool {
	Max := func(x, y int) int {
		if x > y {
			return x
		}
		return y
	}
	n := len(nums)
	var farthest = 0
	for i := 0; i < n-1; i++ {
		farthest = Max(farthest, i+nums[i])
		if farthest <= i {
			return false
		}
	}
	return farthest >= len(nums)-1
}

//leetcode submit region end(Prohibit modification and deletion)
