package medium

func characterReplacement(s string, k int) (ans int) {
	Max := func(x, y int) int {
		if x > y {
			return x
		}
		return y
	}
	var maxCount int
	l, r := 0, 0
	window := make(map[rune]int)
	for r < len(s) {
		c := rune(s[r])
		window[c]++
		maxCount = Max(maxCount, window[c])
		r++
		for r-l > maxCount+k {
			c = rune(s[l])
			window[c]--
			l++
		}
		ans = Max(ans, r-l)
	}
	return
}
func characterReplacement1(s string, k int) (ans int) {
	Max := func(x, y int) int {
		if x > y {
			return x
		}
		return y
	}
	for i := 0; i < 26; i++ {
		target := rune(i + 'A')
		remain, l, r := k, 0, 0
		for r < len(s) {
			c := rune(s[r])
			if c != target {
				remain--
			}
			r++
			for remain < 0 {
				c = rune(s[l])
				if c != target {
					remain++
				}
				l++
			}
			if remain >= 0 {
				ans = Max(ans, r-l)
			}
		}
	}
	return
}
