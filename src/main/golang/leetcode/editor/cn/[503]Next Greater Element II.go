package lc

//leetcode submit region begin(Prohibit modification and deletion)
func nextGreaterElements(nums []int) []int {
	var stack []int
	n := len(nums)
	var ans = make([]int, n)
	for i := 2*n - 1; i >= 0; i-- {
		idx := i % n
		num := nums[idx]
		for len(stack) > 0 && num >= stack[len(stack)-1] {
			stack = stack[:len(stack)-1]
		}
		if len(stack) == 0 {
			ans[idx] = -1
		} else {
			ans[idx] = stack[len(stack)-1]
		}
		stack = append(stack, num)
	}
	return ans
}

//leetcode submit region end(Prohibit modification and deletion)
