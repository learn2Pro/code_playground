package lc

import "math/rand"

//leetcode submit region begin(Prohibit modification and deletion)
type Solution struct {
	Holder map[int][]int
}

func Constructor(nums []int) Solution {
	h := make(map[int][]int)
	for i, num := range nums {
		h[num] = append(h[num], i)
	}
	return Solution{Holder: h}
}

func (this *Solution) Pick(target int) int {
	slice := this.Holder[target]
	n := len(slice)
	x := rand.Intn(n)
	return slice[x]
}

/**
 * Your Solution object will be instantiated and called as such:
 * obj := Constructor(nums);
 * param_1 := obj.Pick(target);
 */
//leetcode submit region end(Prohibit modification and deletion)
