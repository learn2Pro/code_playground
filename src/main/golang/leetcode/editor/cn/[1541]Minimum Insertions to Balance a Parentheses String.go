package lc

//leetcode submit region begin(Prohibit modification and deletion)
func minInsertions(s string) int {
	var ans, need int
	for _, c := range s {
		if c == '(' {
			need += 2
			if need%2 == 1 {
				ans += 1
				need--
			}
		} else {
			need--
			if need < 0 {
				ans++
				need += 2
			}
		}
	}
	return ans + need
}

//leetcode submit region end(Prohibit modification and deletion)
