package lc

//leetcode submit region begin(Prohibit modification and deletion)
func strStr(haystack string, needle string) int {
	//n := len(needle)
	//var window []rune
	//for i, char := range haystack {
	//	window = append(window, char)
	//	if i >= n-1 {
	//		str := string(window)
	//		if str == needle {
	//			return i - n + 1
	//		}
	//		window = window[1:]
	//	}
	//}
	//return -1

	build := func(s string) [][256]int {
		n := len(s)
		dp := make([][256]int, n)
		dp[0][s[0]] = 1
		var x int
		for i := 1; i < n; i++ {
			for k := 0; k < 256; k++ {
				dp[i][k] = dp[x][k]
			}
			dp[i][s[i]] = i + 1
			x = dp[x][s[i]]
		}
		return dp
	}
	dp := build(needle)
	n := len(needle)
	var j int
	for i := 0; i < len(haystack); i++ {
		c := haystack[i]
		j = dp[j][c]
		if j == n {
			return i - n + 1
		}
	}
	return -1
}

//leetcode submit region end(Prohibit modification and deletion)
