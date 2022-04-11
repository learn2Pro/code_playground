package easy

//14. Longest Common Prefix
func longestCommonPrefix1(strs []string) string {
	minLen := 201
	for _, item := range strs {
		if len(item) < minLen {
			minLen = len(item)
		}
	}
	ans := ""
	for i := 0; i < minLen; i++ {
		first := strs[0][0 : i+1]
		num := 1
		for j := 1; j < len(strs); j++ {
			if strs[j][0:i+1] == first {
				num += 1
			}
		}
		if num == len(strs) {
			ans = first
		} else {
			break
		}
	}
	return ans
}
func longestCommonPrefix(strs []string) string {
	ans := ""
	for i := 0; i < len(strs[0]); i++ {
		for j := 0; j < len(strs); j++ {
			if i >= len(strs[j]) || strs[j][i] != strs[0][i] {
				return ans
			}
		}
		ans += string(strs[0][i])
	}
	return ans
}
