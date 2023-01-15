package lc

//leetcode submit region begin(Prohibit modification and deletion)
func generateParenthesis(n int) []string {
	var ans []string
	var tracker []rune
	var generate func(left, right int)
	generate = func(left, right int) {
		if left > right {
			return
		}
		if left < 0 || right < 0 {
			return
		}
		if left == 0 && right == 0 {
			ans = append(ans, string(tracker))
			return
		}
		tracker = append(tracker, '(')
		generate(left-1, right)
		tracker = tracker[:len(tracker)-1]

		tracker = append(tracker, ')')
		generate(left, right-1)
		tracker = tracker[:len(tracker)-1]
	}
	generate(n, n)
	return ans
}
func generateParenthesis1(n int) []string {
	cache := make(map[int][]string)

	var generate func(x int) []string
	generate = func(x int) []string {
		if r, ok := cache[x]; ok {
			return r
		}
		var ans []string
		if x == 0 {
			ans = append(ans, "")
		} else {
			for i := 0; i < x; i++ {
				for _, s1 := range generate(i) {
					for _, s2 := range generate(x - i - 1) {
						ans = append(ans, "("+s1+")"+s2)
					}
				}
			}
		}
		cache[x] = ans
		return ans
	}
	return generate(n)
}

//leetcode submit region end(Prohibit modification and deletion)
