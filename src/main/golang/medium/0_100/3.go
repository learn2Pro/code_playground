package medium

func lengthOfLongestSubstring(s string) int {
	Max := func(x, y int) int {
		if x > y {
			return x
		}
		return y
	}
	window := make(map[rune]int)
	var l, r int
	var ans int
	for r < len(s) {
		var c rune
		c, r = rune(s[r]), r+1
		window[c]++
		for window[c] > 1 {
			window[rune(s[l])]--
			l++
		}
		ans = Max(ans, r-l)
	}
	return ans
}
func lengthOfLongestSubstring1(s string) int {
	holder := make(map[uint8]bool)
	var ans, left, right int
	for right < len(s) {
		if _, ok := holder[s[right]]; ok {
			delete(holder, s[left])
			left++
		} else {
			holder[s[right]] = true
			right++
		}
		ans = Max(ans, len(holder))
	}
	return ans
}
func Max(x, y int) int {
	if x < y {
		return y
	}
	return x
}
