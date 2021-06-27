package medium

func lengthOfLongestSubstring(s string) int {
	holder := make(map[uint8]bool)
	var ans, left, right int
	for ; right < len(s); {
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
