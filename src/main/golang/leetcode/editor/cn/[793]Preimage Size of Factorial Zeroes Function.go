package lc

import "sort"

//leetcode submit region begin(Prohibit modification and deletion)
func preimageSizeFZF(k int) int {
	zeta := func(n int) (ans int) {
		for n > 0 {
			n /= 5
			ans += n
		}
		return
	}
	searchK := func(k int) int {
		return sort.Search(5*k, func(i int) bool {
			return zeta(i) >= k
		})
	}
	return searchK(k+1) - searchK(k)
}

//leetcode submit region end(Prohibit modification and deletion)
