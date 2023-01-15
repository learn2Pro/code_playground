package lc

//leetcode submit region begin(Prohibit modification and deletion)
func romanToInt(s string) (ans int) {
	var mapping = map[byte]int{'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}
	n := len(s)
	for i := 0; i < n; i++ {
		v0 := mapping[s[i]]
		if i < n-1 && v0 < mapping[s[i+1]] {
			ans -= v0
		} else {
			ans += v0
		}
	}
	return
}

//leetcode submit region end(Prohibit modification and deletion)
