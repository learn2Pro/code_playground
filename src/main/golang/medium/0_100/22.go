package medium

func generateParenthesis(n int) []string {
	var cache = make(map[int][]string)

	var generate func(x int) []string
	generate = func(x int) []string {
		if res, ok := cache[x]; ok {
			return res
		}
		var ans []string
		if x == 0 {
			ans = append(ans, "")
		} else {
			for c := 0; c < x; c++ {
				for _, s1 := range generate(c) {
					for _, s2 := range generate(x - c - 1) {
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

//func generateParenthesis(n int) []string {
//	var ans []string
//	var tracker []rune
//	var backtrack func(leftBracketSize, rightBracketSize int)
//	backtrack = func(leftBracketSize, rightBracketSize int) {
//		if len(tracker) == 2*n {
//			ans = append(ans, string(tracker))
//			return
//		}
//		if leftBracketSize < n { //choice of add left bracket
//			tracker = append(tracker, '(')
//			backtrack(leftBracketSize+1, rightBracketSize)
//			tracker = tracker[:len(tracker)-1]
//		}
//		if rightBracketSize < leftBracketSize { //choice of add right bracket
//			tracker = append(tracker, ')')
//			backtrack(leftBracketSize, rightBracketSize+1)
//			tracker = tracker[:len(tracker)-1]
//		}
//
//	}
//	backtrack(0, 0)
//	return ans
//}
