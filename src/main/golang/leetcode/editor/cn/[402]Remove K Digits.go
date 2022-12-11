package lc

import "strings"

//leetcode submit region begin(Prohibit modification and deletion)
func removeKdigits(num string, k int) string {
	var stack []byte
	for i := range num {
		c := num[i]
		for k > 0 && len(stack) > 0 && c < stack[len(stack)-1] {
			stack = stack[:len(stack)-1]
			k--
		}
		stack = append(stack, c)
	}
	stack = stack[:len(stack)-k]
	ans := strings.TrimLeft(string(stack), "0")
	if ans == "" {
		return "0"
	}
	return ans
}

//leetcode submit region end(Prohibit modification and deletion)
