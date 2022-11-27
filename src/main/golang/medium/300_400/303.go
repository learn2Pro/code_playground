package medium

type NumArray struct {
	prefix []int
}

func Constructor1(nums []int) NumArray {
	p := make([]int, len(nums)+1)
	for i := 1; i <= len(nums); i++ {
		p[i] = p[i-1] + nums[i-1]
	}
	return NumArray{prefix: p}
}

func (this *NumArray) SumRange(left int, right int) int {
	return this.prefix[right+1] - this.prefix[left]
}
