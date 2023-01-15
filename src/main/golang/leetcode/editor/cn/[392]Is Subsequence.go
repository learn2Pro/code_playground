package lc

import "sort"

//leetcode submit region begin(Prohibit modification and deletion)
func isSubsequence(s string, t string) bool {
	//var i, j int
	//for i < len(s) && j < len(t) {
	//	if s[i] == t[j] {
	//		i++
	//	}
	//	j++
	//}
	//return i == len(s)
	index := make(map[rune][]int)
	for i, c := range t {
		index[c] = append(index[c], i)
	}
	var i = -1
	for _, c := range s {
		lst, ok := index[c]
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

//leetcode submit region end(Prohibit modification and deletion)
