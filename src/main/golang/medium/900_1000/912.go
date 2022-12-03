package medium

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
		var i, j = l, mid + 1
		for k := l; k <= r; k++ {
			if i == mid+1 {
				nums[k] = tmp[j]
				j++
			} else if j == r+1 {
				nums[k] = tmp[i]
				i++
			} else if tmp[i] > tmp[j] {
				nums[k] = tmp[j]
				j++
			} else {
				nums[k] = tmp[i]
				i++
			}
		}
	}
	mergeSort(0, n-1)
	return nums
}
