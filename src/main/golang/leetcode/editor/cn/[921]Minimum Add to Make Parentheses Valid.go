package lc

//leetcode submit region begin(Prohibit modification and deletion)
func minAddToMakeValid(s string) (ans int) {
	var left int
	for _, c := range s {
		if c == '(' {
			left++
		} else {
			left--
		}
		if left < 0 {
			ans += 1
			left++
		}
	}
	if left > 0 {
		ans += left
	}
	return
}

//leetcode submit region end(Prohibit modification and deletion)
