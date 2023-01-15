package lc

//leetcode submit region begin(Prohibit modification and deletion)
func calculate(s string) int {
	isDigit := func(c rune) bool {
		if c >= '0' && c <= '9' {
			return true
		}
		return false
	}
	var calc0 func(chars *[]rune) int
	calc0 = func(chars *[]rune) int {
		sign, num := '+', 0
		var stack []int
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
				case '*':
					stack[len(stack)-1] = stack[len(stack)-1] * num
				case '/':
					stack[len(stack)-1] = stack[len(stack)-1] / num
				}
				num, sign = 0, c
			}
			if c == ')' {
				break
			}
		}
		var ans int
		for _, n := range stack {
			ans += n
		}
		return ans
	}
	arr := []rune(s)
	return calc0(&arr)
}

//leetcode submit region end(Prohibit modification and deletion)
