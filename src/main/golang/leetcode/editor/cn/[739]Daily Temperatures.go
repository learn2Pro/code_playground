package lc

//leetcode submit region begin(Prohibit modification and deletion)
func dailyTemperatures(temperatures []int) []int {
	n := len(temperatures)
	var stack []int
	var ans = make([]int, n)
	for i := n - 1; i >= 0; i-- {
		curr := temperatures[i]
		for len(stack) > 0 && curr >= temperatures[stack[len(stack)-1]] {
			stack = stack[:len(stack)-1]
		}
		if len(stack) > 0 {
			ans[i] = stack[len(stack)-1] - i
		}
		stack = append(stack, i)
	}
	return ans
}

//leetcode submit region end(Prohibit modification and deletion)
