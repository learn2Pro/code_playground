package easy

func strStr1(haystack string, needle string) int {
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

func strStr(haystack string, needle string) int {
	if len(haystack) == 0 {
		return -1
	}
	if len(needle) == 0 {
		return 0
	}

	for i := 0; i < len(haystack); i++ {
		if haystack[i] == needle[0] && compare(haystack, needle, i) {
			return i
		}
	}
	return -1
}

func compare(parent string, input string, i int) bool {
	if len(parent)-i < len(input) {
		return false
	}
	for j, k := i, 0; k < len(input); k++ {
		if parent[j] != input[k] {
			return false
		}
		j++
	}
	return true
}
