package lc

//leetcode submit region begin(Prohibit modification and deletion)
func sortArray(nums []int) []int {
	//n := len(nums)
	//for i := 0; i < n; i++ {
	//	for j := i + 1; j < n; j++ {
	//		if nums[i] > nums[j] {
	//			nums[i], nums[j] = nums[j], nums[i]
	//		}
	//	}
	//}
	//return nums
	//n := len(nums)
	//var tmp = make([]int, n)
	//var mergeSort func(l, r int)
	//mergeSort = func(l, r int) {
	//	if l == r {
	//		return
	//	}
	//	mid := l + (r-l)/2
	//	mergeSort(l, mid)
	//	mergeSort(mid+1, r)
	//	for i := l; i <= r; i++ {
	//		tmp[i] = nums[i]
	//	}
	//	var i, j = l, mid + 1
	//	for k := l; k <= r; k++ {
	//		if i == mid+1 {
	//			nums[k] = tmp[j]
	//			j++
	//		} else if j == r+1 {
	//			nums[k] = tmp[i]
	//			i++
	//		} else if tmp[i] > tmp[j] {
	//			nums[k] = tmp[j]
	//			j++
	//		} else {
	//			nums[k] = tmp[i]
	//			i++
	//		}
	//	}
	//}
	//mergeSort(0, n-1)
	//return nums
	n := len(nums)
	var quickSort func(l, r int)
	quickSort = func(l, r int) {
		if l >= r {
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
		quickSort(l, p0-1)
		quickSort(p0+1, r)
	}
	quickSort(0, n-1)
	return nums
}

//leetcode submit region end(Prohibit modification and deletion)
