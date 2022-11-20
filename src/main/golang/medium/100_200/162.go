package medium

import "math"

func findPeakElement(nums []int) int {

	//1=asc,-1=desc,0=peek
	isAsc := func(i int) int {
		l, r := i-1, i+1
		var num0, num1 int
		if l < 0 {
			num0 = math.MinInt64
		} else {
			num0 = nums[l]
		}
		if r >= len(nums) {
			num1 = math.MinInt64
		} else {
			num1 = nums[r]
		}
		if nums[i] > num0 && nums[i] < num1 { // \
			return 1
		} else if nums[i] < num0 && nums[i] > num1 { // /
			return -1
		} else if nums[i] > num0 && nums[i] > num1 { // \/
			return 0
		} else { // /\
			return -1
		}
	}
	l, r := 0, len(nums)-1
	for l <= r {
		mid := l + (r-l)/2
		asc := isAsc(mid)
		if asc == 0 {
			return mid
		} else if asc == 1 {
			l = mid + 1
		} else if asc == -1 {
			r = mid - 1
		}
	}
	return -1
}
