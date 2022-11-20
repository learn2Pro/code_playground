package easy

func searchInsert(nums []int, target int) int {
	l, r := 0, len(nums)
	for l < r {
		mid := l + (r-l)/2
		if nums[mid] == target {
			return mid
		} else if nums[mid] > target {
			r = mid
		} else {
			l = mid + 1
		}
	}
	return r
}

func searchInsert1(nums []int, target int) int {
	if len(nums) < 1 {
		return 0
	}
	s, e := 0, len(nums)
	for s < e {
		mid := (s + e) >> 1
		if nums[mid] < target {
			s = mid + 1
		} else {
			e = mid
		}
	}
	return s
}
