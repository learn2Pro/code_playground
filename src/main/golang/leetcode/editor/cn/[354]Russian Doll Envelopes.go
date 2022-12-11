package lc

import "sort"

//leetcode submit region begin(Prohibit modification and deletion)
func maxEnvelopes(envelopes [][]int) int {
	sort.Slice(envelopes, func(i, j int) bool {
		if envelopes[i][0] == envelopes[j][0] {
			return envelopes[i][1] > envelopes[j][1]
		} else {
			return envelopes[i][0] < envelopes[j][0]
		}
	})
	n := len(envelopes)
	top := make([]int, n)
	var piles int
	for i := 0; i < n; i++ {
		num := envelopes[i][1]
		l, r := 0, piles
		for l < r {
			mid := l + (r-l)/2
			if top[mid] < num {
				l = mid + 1
			} else {
				r = mid
			}
		}
		if l == piles {
			piles++
		}
		top[l] = num
	}
	return piles
}

//leetcode submit region end(Prohibit modification and deletion)
