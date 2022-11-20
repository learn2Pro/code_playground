package medium

func findAnagrams(s string, t string) []int {
	window, tmap := make(map[rune]int), make(map[rune]int)
	for _, c := range t {
		tmap[c]++
	}
	var l, r, valid int
	var ans []int
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
			if r-l == len(t) {
				ans = append(ans, l)
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
