package lc

//leetcode submit region begin(Prohibit modification and deletion)
func strStr(haystack string, needle string) int {
	n := len(needle)
	var window []rune
	for i, char := range haystack {
		window = append(window, char)
		if i >= n-1 {
			str := string(window)
			if str == needle {
				return i - n + 1
			}
			window = window[1:]
		}
	}
	return -1
}

//leetcode submit region end(Prohibit modification and deletion)
