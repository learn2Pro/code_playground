package lc

//leetcode submit region begin(Prohibit modification and deletion)
func reversePairs(nums []int) (cnt int) {

	n := len(nums)
	var tmp = make([]int, n)

	var mergeSort func(l, r int)
	mergeSort = func(l, r int) {
		if l == r {
			return
		}
		mid := l + (r-l)/2
		mergeSort(l, mid)
		mergeSort(mid+1, r)
		for i := l; i <= r; i++ {
			tmp[i] = nums[i]
		}
		var end = mid + 1
		for i := l; i < mid+1; i++ {
			for end <= r && tmp[i] > tmp[end]*2 {
				end++
			}
			cnt += end - mid - 1
		}
		var p0, p1 = l, mid + 1
		for i := l; i <= r; i++ {
			if p0 == mid+1 {
				nums[i] = tmp[p1]
				p1++
			} else if p1 == r+1 {
				nums[i] = tmp[p0]
				p0++
			} else if tmp[p0] <= tmp[p1] {
				nums[i] = tmp[p0]
				p0++
			} else {
				nums[i] = tmp[p1]
				p1++
			}
		}
	}
	mergeSort(0, n-1)
	return
}

//leetcode submit region end(Prohibit modification and deletion)
