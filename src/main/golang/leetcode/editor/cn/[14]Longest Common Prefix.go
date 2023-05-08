package lc

//leetcode submit region begin(Prohibit modification and deletion)
func longestCommonPrefix(strs []string) string {
	//var prefix []byte
	//var i int
	//n := len(strs)
	//for {
	//	var p byte
	//	var end = false
	//	for j := 0; j < n; j++ {
	//		if i < len(strs[j]) && j == 0 {
	//			p = strs[j][i]
	//		} else {
	//			if i >= len(strs[j]) || p != strs[j][i] {
	//				end = true
	//			}
	//		}
	//	}
	//	if end {
	//		break
	//	} else {
	//		prefix = append(prefix, p)
	//	}
	//	i++
	//}
	//return string(prefix)
	//if len(strs) == 0 {
	//	return ""
	//}
	//for i := 0; i < len(strs[0]); i++ {
	//	for j := 1; j < len(strs); j++ {
	//		if i >= len(strs[j]) || strs[j][i] != strs[0][i] {
	//			return strs[0][:i]
	//		}
	//	}
	//}
	//return strs[0]
	Min := func(x, y int) int {
		if x > y {
			return y
		}
		return x
	}
	lcs := func(s1, s2 string) string {
		n := Min(len(s1), len(s2))
		var i int
		for ; i < n; i++ {
			if s1[i] != s2[i] {
				break
			}
		}
		return s1[:i]
	}
	if len(strs) == 0 {
		return ""
	}
	prefix := strs[0]
	for i := 1; i < len(strs); i++ {
		prefix = lcs(prefix, strs[i])
		if len(prefix) == 0 {
			return ""
		}
	}
	return prefix

}

//leetcode submit region end(Prohibit modification and deletion)
