package lc

//leetcode submit region begin(Prohibit modification and deletion)
func trap(height []int) (sum int) {
	Min := func(x, y int) int {
		if x < y {
			return x
		}
		return y
	}
	var stack []int
	for i := 0; i < len(height); i++ {
		curr := height[i]
		for len(stack) > 0 && curr > height[stack[len(stack)-1]] {
			v := height[stack[len(stack)-1]]
			stack = stack[:len(stack)-1]
			if len(stack) == 0 { //左边没柱子，不能积水
				break
			}
			distance := i - stack[len(stack)-1] - 1
			h := Min(curr, height[stack[len(stack)-1]])
			sum += distance * (h - v)
		}
		stack = append(stack, i)
	}
	return
}

//leetcode submit region end(Prohibit modification and deletion)
