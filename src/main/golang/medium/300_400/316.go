package medium

func removeDuplicateLetters(s string) string {
	visited, num := make([]int, 26), make([]int, 26)
	var stack []rune
	for _, char := range s {
		num[char-'a'] += 1
	}
	for _, char := range s {
		idx := char - 'a'
		if v := visited[idx]; v == 0 {
			for len(stack) > 0 && stack[len(stack)-1] > char {
				if num[stack[len(stack)-1]-'a'] > 0 {
					visited[stack[len(stack)-1]-'a'] = 0
					stack = stack[:len(stack)-1]
				} else {
					break
				}
			}
			visited[char-'a'] = 1
			stack = append(stack, char)

		}
		num[idx] -= 1
	}
	return string(stack)
}
