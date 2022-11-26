package medium

func longestSubstring(s string, k int) (ans int) {
	Max := func(x, y int) int {
		if x > y {
			return x
		}
		return y
	}
	for t := 1; t <= 26; t++ {
		window := make(map[rune]int)
		var total, lessK int
		l, r := 0, 0
		for r < len(s) {
			c := rune(s[r])
			window[c]++
			if window[c] == 1 {
				total += 1
				lessK += 1
			}
			if window[c] == k {
				lessK -= 1
			}
			r += 1
			for total > t {
				c = rune(s[l])
				window[c]--
				if window[c] == k-1 {
					lessK += 1
				}
				if window[c] == 0 {
					total -= 1
					lessK -= 1
				}
				l++
			}
			if lessK == 0 {
				ans = Max(ans, r-l)
			}
		}
	}
	return
}

func longestSubstring1(s string, k int) int {
	Max := func(x, y int) int {
		if x > y {
			return x
		}
		return y
	}
	window := make(map[rune]int)
	var charNum, validNum int
	var ans int
	l, r := 0, 0
	for r < len(s) {
		c := rune(s[r])
		window[c]++
		if window[c] == 1 {
			charNum += 1
		}
		if window[c] == k {
			validNum += 1
		}
		r += 1
		var v int
		if r < len(s) { //not in current valid chars
			v = window[rune(s[r])]
		} else {
			v = 0
		}
		for v == 0 && validNum != 0 && validNum == charNum {
			ans = Max(ans, r-l)
			c = rune(s[l])
			window[c]--
			if window[c] == k-1 {
				validNum -= 1
			}
			if window[c] == 0 {
				charNum -= 1
			}
			l++
		}
	}
	return ans
}
