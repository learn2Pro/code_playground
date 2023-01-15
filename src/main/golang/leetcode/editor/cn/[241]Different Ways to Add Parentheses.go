package lc

import "strconv"

//leetcode submit region begin(Prohibit modification and deletion)
func diffWaysToCompute(expression string) []int {
	var ans []int
	n := len(expression)
	for i := 0; i < n; i++ {
		if expression[i] == '+' || expression[i] == '-' || expression[i] == '*' {
			left := diffWaysToCompute(expression[:i])
			right := diffWaysToCompute(expression[i+1:])
			for _, s0 := range left {
				for _, s1 := range right {
					if expression[i] == '+' {
						ans = append(ans, s0+s1)
					} else if expression[i] == '-' {
						ans = append(ans, s0-s1)
					} else if expression[i] == '*' {
						ans = append(ans, s0*s1)
					}
				}
			}
		}
	}
	if len(ans) == 0 {
		num, _ := strconv.Atoi(expression)
		ans = append(ans, num)
	}
	return ans
}

//leetcode submit region end(Prohibit modification and deletion)
