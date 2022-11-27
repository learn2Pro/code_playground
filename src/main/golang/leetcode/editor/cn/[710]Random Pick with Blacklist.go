package lc

import "math/rand"

//leetcode submit region begin(Prohibit modification and deletion)
type Solution struct {
	Mapper map[int]int
	N      int
}

func Constructor(n int, blacklist []int) Solution {
	m := make(map[int]int)
	sz := n - len(blacklist)
	for _, black := range blacklist {
		m[black] = -1
	}
	last := n - 1
	for _, black := range blacklist {
		if black >= sz {
			continue
		}
		for {
			_, ok := m[last]
			if !ok {
				break
			}
			last--
		}
		m[black] = last
		last--
	}

	return Solution{
		Mapper: m,
		N:      sz,
	}
}

func (this *Solution) Pick() int {
	//x := rand.Intn(this.N)
	//return this.Nums[x]
	x := rand.Intn(this.N)
	if _, ok := this.Mapper[x]; ok {
		return this.Mapper[x]
	}
	return x
}

/**
 * Your Solution object will be instantiated and called as such:
 * obj := Constructor(n, blacklist);
 * param_1 := obj.Pick();
 */
//leetcode submit region end(Prohibit modification and deletion)
