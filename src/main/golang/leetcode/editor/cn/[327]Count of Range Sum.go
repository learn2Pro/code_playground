package lc

//leetcode submit region begin(Prohibit modification and deletion)
func countRangeSum(nums []int, lower int, upper int) (cnt int) {
	n := len(nums)
	prefix := make([]int, n+1)
	tmp := make([]int, n+1)
	for i := 1; i <= n; i++ {
		prefix[i] = prefix[i-1] + nums[i-1]
	}
	var mergeSort func(l, r int)
	mergeSort = func(l, r int) {
		if l >= r {
			return
		}
		mid := l + (r-l)/2
		mergeSort(l, mid)
		mergeSort(mid+1, r)
		for i := l; i <= r; i++ {
			tmp[i] = prefix[i]
		}
		var s, e = mid + 1, mid + 1
		for i := l; i <= mid; i++ {
			if s <= r && prefix[s]-prefix[i] < lower {
				s++
			}
			if e <= r && prefix[e]-prefix[i] <= upper {
				e++
			}
			cnt += e - s
		}
		var p0, p1 = l, mid + 1
		for i := l; i <= r; i++ {
			if p0 == mid+1 {
				prefix[i] = tmp[p1]
				p1++
			} else if p1 == r+1 {
				prefix[i] = tmp[p0]
				p0++
			} else if tmp[p0] <= tmp[p1] {
				prefix[i] = tmp[p0]
				p0++
			} else {
				prefix[i] = tmp[p1]
				p1++
			}
		}
	}
	mergeSort(0, n)
	return
}

//leetcode submit region end(Prohibit modification and deletion)
