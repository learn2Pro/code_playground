package hard

import "math"

func minWindow(s string, t string) string {
	window, tmap := make(map[rune]int), make(map[rune]int)
	for _, c := range t {
		tmap[c]++
	}
	var l, r, valid int
	var ans = ""
	var minimalLen = math.MaxInt32
	for r < len(s) {
		var c rune
		c, r = rune(s[r]), r+1
		if cnt, ok := tmap[c]; ok {
			window[c]++
			if window[c] == cnt {
				valid += 1
			}
		}

		for valid == len(tmap) {
			if r-l < minimalLen {
				minimalLen = r - l
				ans = s[l:r]
			}
			c, l = rune(s[l]), l+1
			if _, ok := tmap[c]; ok {
				if window[c] == tmap[c] {
					valid -= 1
				}
				window[c]--
			}
		}
	}
	return ans
}
