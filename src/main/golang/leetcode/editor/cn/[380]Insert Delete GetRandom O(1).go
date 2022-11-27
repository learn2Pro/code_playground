package lc

import "math/rand"

//leetcode submit region begin(Prohibit modification and deletion)
type RandomizedSet struct {
	ValToIndx map[int]int
	Nums      []int
}

func Constructor() RandomizedSet {
	return RandomizedSet{
		ValToIndx: make(map[int]int),
	}
}

func (this *RandomizedSet) Insert(val int) bool {
	if _, ok := this.ValToIndx[val]; ok {
		return false
	} else {
		this.Nums = append(this.Nums, val)
		this.ValToIndx[val] = len(this.Nums) - 1
		return true
	}
}

func (this *RandomizedSet) Remove(val int) bool {
	if idx, ok := this.ValToIndx[val]; ok {
		n := len(this.Nums)
		if n == 1 {
			delete(this.ValToIndx, val)
		} else {
			this.ValToIndx[this.Nums[n-1]] = idx
			this.Nums[idx], this.Nums[n-1] = this.Nums[n-1], this.Nums[idx]
			delete(this.ValToIndx, val)
		}
		this.Nums = this.Nums[:n-1]
		return true
	} else {
		return false
	}
}

func (this *RandomizedSet) GetRandom() int {
	n := len(this.Nums)
	x := rand.Intn(n)
	return this.Nums[x]
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * obj := Constructor();
 * param_1 := obj.Insert(val);
 * param_2 := obj.Remove(val);
 * param_3 := obj.GetRandom();
 */
//leetcode submit region end(Prohibit modification and deletion)
