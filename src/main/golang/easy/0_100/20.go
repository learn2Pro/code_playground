package easy

//20. Valid Parentheses
func isValid(s string) bool {
	prefix := map[string]string{
		"]": "[",
		")": "(",
		"}": "{",
	}
	var stack []string
	for i, _ := range s {
		bracket, ok := prefix[string(s[i])]
		if ok {
			//not found
			if len(stack) == 0 || stack[len(stack)-1] != bracket {
				return false
			} else {
				//pop
				stack = stack[0 : len(stack)-1]
			}
		} else {
			// apend to stack
			stack = append(stack, string(s[i]))
		}
	}
	return len(stack) == 0
}
