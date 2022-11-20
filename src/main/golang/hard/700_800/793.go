package hard

import "sort"

func preimageSizeFZF(k int) int {
	zeta := func(n int) (res int) {
		for n > 0 {
			n /= 5
			res += n
		}
		return
	}
	searchNK := func(x int) int {
		return sort.Search(5*x, func(y int) bool { return zeta(y) >= x })
	}

	return searchNK(k+1) - searchNK(k)
}
