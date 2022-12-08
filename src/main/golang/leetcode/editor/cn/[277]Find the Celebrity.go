package lc

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * The knows API is already defined for you.
 *     knows := func(a int, b int) bool
 */
func solution(knows func(a int, b int) bool) func(n int) int {
	return func(n int) int {
		//if n == 1 {
		//	return 0
		//}
		//var queue []int
		//for i := 0; i < n; i++ {
		//	queue = append(queue, i)
		//}
		//for len(queue) >= 2 {
		//	cand, other := queue[0], queue[1]
		//	queue = queue[2:]
		//	if knows(cand, other) || !knows(other, cand) {
		//		queue = append(queue, other)
		//	} else {
		//		queue = append(queue, cand)
		//	}
		//}
		//cand := queue[0]
		//for i := 0; i < n; i++ {
		//	if i == cand {
		//		continue
		//	}
		//	if !knows(i, cand) || knows(cand, i) {
		//		return -1
		//	}
		//}
		//return cand
		cand := 0
		for i := 1; i < n; i++ {
			if knows(cand, i) || !knows(i, cand) {
				cand = i
			}
		}
		for i := 0; i < n; i++ {
			if i == cand {
				continue
			}
			if knows(cand, i) || !knows(i, cand) {
				return -1
			}
		}
		return cand
	}
}

//leetcode submit region end(Prohibit modification and deletion)
