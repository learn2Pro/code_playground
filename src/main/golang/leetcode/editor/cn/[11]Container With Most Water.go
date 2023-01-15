package lc

//leetcode submit region begin(Prohibit modification and deletion)
func maxArea(height []int) (ans int) {
	Max := func(x, y int) int {
		if x > y {
			return x
		}
		return y
	}
	Min := func(x, y int) int {
		if x > y {
			return y
		}
		return x
	}
	l, r := 0, len(height)-1
	for l < r {
		ans = Max(ans, Min(height[l], height[r])*(r-l))
		if height[l] < height[r] {
			l++
		} else {
			r--
		}
	}
	return ans
}

//leetcode submit region end(Prohibit modification and deletion)
