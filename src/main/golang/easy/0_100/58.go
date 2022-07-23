package easy

//58. 最后一个单词的长度
func lengthOfLastWord(s string) int {
	if len(s) <= 0 {
		return 0
	}
	acc, start := 0, false
	for i := len(s) - 1; i >= 0; i-- {
		if !start && s[i] == ' ' {
			continue
		}
		start = true
		if start && s[i] != ' ' {
			acc += 1
		} else {
			return acc
		}
	}
	return acc
}
