package lc

import (
	"math/rand"
	"sort"
)

//leetcode submit region begin(Prohibit modification and deletion)
type Solution struct {
	prefix []int
}

func Constructor(w []int) Solution {
	p := make([]int, len(w)+1)
	for i := 1; i <= len(w); i++ {
		p[i] = p[i-1] + w[i-1]
	}
	return Solution{prefix: p}
}

func (this *Solution) PickIndex() int {
	n := len(this.prefix)
	r := rand.Intn(this.prefix[n-1]) + 1
	return sort.SearchInts(this.prefix, r) - 1
}

/**
 * Your Solution object will be instantiated and called as such:
 * obj := Constructor(w);
 * param_1 := obj.PickIndex();
 */
//leetcode submit region end(Prohibit modification and deletion)
