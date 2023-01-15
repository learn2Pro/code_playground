package lc

//leetcode submit region begin(Prohibit modification and deletion)
func isValid(s string) bool {
	var stack []rune
	leftOf := func(c rune) rune {
		if c == ']' {
			return '['
		} else if c == '}' {
			return '{'
		} else {
			return '('
		}
	}
	for _, c := range s {
		if c == '[' || c == '(' || c == '{' {
			stack = append(stack, c)
		} else {
			if len(stack) > 0 && stack[len(stack)-1] == leftOf(c) {
				stack = stack[:len(stack)-1]
			} else {
				return false
			}
		}
	}
	return len(stack) == 0
}

//leetcode submit region end(Prohibit modification and deletion)
