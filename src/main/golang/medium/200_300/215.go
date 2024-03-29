package medium

func findKthLargest(nums []int, k int) int {
	n := len(nums)
	var ans int
	var quickSort func(l, r int)
	quickSort = func(l, r int) {
		if l > r {
			return
		}
		pivot := nums[l]
		nums[l], nums[r] = nums[r], nums[l]
		var p0 = l
		for p1 := l; p1 < r; p1++ {
			if nums[p1] < pivot {
				nums[p0], nums[p1] = nums[p1], nums[p0]
				p0++
			}
		}

		nums[p0], nums[r] = nums[r], nums[p0]
		if n-p0 == k {
			ans = nums[p0]
			return
		}
		quickSort(l, p0-1)
		quickSort(p0+1, r)
	}
	quickSort(0, n-1)
	return ans
}
