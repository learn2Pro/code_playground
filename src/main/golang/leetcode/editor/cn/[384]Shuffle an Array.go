package lc

import "math/rand"

//leetcode submit region begin(Prohibit modification and deletion)
type Solution struct {
	origin []int
	nums   []int
	N      int
}

func Constructor(nums []int) Solution {
	origin := make([]int, len(nums))
	copy(origin, nums)
	return Solution{origin: origin, nums: nums, N: len(nums)}
}

func (this *Solution) Reset() []int {
	reset := make([]int, this.N)
	copy(reset, this.origin)
	this.nums = reset
	return reset
}

func (this *Solution) Shuffle() []int {
	n := this.N
	for i := 0; i < n; i++ {
		r := i + rand.Intn(n-i)
		this.nums[i], this.nums[r] = this.nums[r], this.nums[i]
	}
	return this.nums
}

/**
 * Your Solution object will be instantiated and called as such:
 * obj := Constructor(nums);
 * param_1 := obj.Reset();
 * param_2 := obj.Shuffle();
 */
//leetcode submit region end(Prohibit modification and deletion)
