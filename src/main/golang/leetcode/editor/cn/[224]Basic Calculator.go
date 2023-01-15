package lc

//leetcode submit region begin(Prohibit modification and deletion)
func calculate(s string) int {

	isDigit := func(c rune) bool {
		if c >= '0' && c <= '9' {
			return true
		}
		return false
	}
	arr := []rune(s)
	var calc0 func(chars *[]rune) int
	calc0 = func(chars *[]rune) int {
		var stack []int
		sign := '+'
		var num int
		for len(*chars) > 0 {
			p := *chars
			c := p[0]
			*chars = p[1:]
			if isDigit(c) {
				num = num*10 + int(c-'0')
			}
			if c == '(' {
				num = calc0(chars)
			}
			if (!isDigit(c) && c != ' ') || len(*chars) == 0 {
				switch sign {
				case '+':
					stack = append(stack, num)
				case '-':
					stack = append(stack, -num)
					//case '*':
					//	stack[len(stack)-1] *= num
					//case '/':
					//	stack[len(stack)-1] /= num
				}
				sign, num = c, 0
			}
			if c == ')' {
				break
			}
		}
		var ans int
		for _, n0 := range stack {
			ans += n0
		}
		return ans

	}
	return calc0(&arr)
}

//leetcode submit region end(Prohibit modification and deletion)
