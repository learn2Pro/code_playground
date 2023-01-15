package lc

import "sort"

//leetcode submit region begin(Prohibit modification and deletion)
func numMatchingSubseq(s string, words []string) (ans int) {
	pattern := make(map[rune][]int)
	for i, c := range s {
		pattern[c] = append(pattern[c], i)
	}
	isSubsequence := func(input string) bool {
		var i = -1
		for _, c := range input {
			lst, ok := pattern[c]
			if !ok {
				return false
			}
			loc := sort.SearchInts(lst, i)
			if loc == len(lst) {
				return false
			}
			i = lst[loc] + 1
		}
		return true
	}
	for _, word := range words {
		if isSubsequence(word) {
			ans += 1
		}
	}
	return
}

//leetcode submit region end(Prohibit modification and deletion)
