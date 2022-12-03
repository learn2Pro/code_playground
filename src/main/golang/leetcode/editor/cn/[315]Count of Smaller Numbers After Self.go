package lc

//leetcode submit region begin(Prohibit modification and deletion)
func countSmaller(nums []int) []int {
	n := len(nums)
	var tmp = make([][]int, n)
	var count = make([]int, n)
	var arr = make([][]int, n)
	for i := 0; i < n; i++ {
		arr[i] = []int{nums[i], i}
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
			tmp[i] = arr[i]
		}
		var p0, p1 = l, mid + 1
		for k := l; k <= r; k++ {
			if p0 == mid+1 {
				arr[k] = tmp[p1]
				p1++
			} else if p1 == r+1 {
				arr[k] = tmp[p0]
				count[arr[k][1]] += p1 - mid - 1
				p0++
			} else if tmp[p0][0] <= tmp[p1][0] {
				arr[k] = tmp[p0]
				count[arr[k][1]] += p1 - mid - 1
				p0++
			} else {
				arr[k] = tmp[p1]
				p1++
			}
		}
	}
	mergeSort(0, n-1)
	return count
	//n := len(nums)
	//var count = make([]int, n)
	//var arr = make([][]int, n)
	//for i := 0; i < n; i++ {
	//	arr[i] = []int{nums[i], i}
	//}
	//var quickSort func(l, r int)
	//quickSort = func(l, r int) {
	//	if l >= r {
	//		return
	//	}
	//	pivot, idx := arr[l][0], arr[l][1]
	//	arr[l], arr[r] = arr[r], arr[l]
	//	var p0 = l
	//	for p1 := l; p1 < r-1; p1++ {
	//		if arr[p1][0] < pivot {
	//			arr[p0], arr[p1] = arr[p1], arr[p0]
	//			p0++
	//		}
	//	}
	//	arr[p0], arr[r] = arr[r], arr[p0]
	//	count[idx] = r - p0
	//	quickSort(l, p0-1)
	//	quickSort(p0+1, r)
	//}
	//return count
}

//leetcode submit region end(Prohibit modification and deletion)
