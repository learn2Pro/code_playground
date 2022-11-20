package medium

func findMin(nums []int) int {
	n := len(nums)
	l, r := 0, n-1
	for l < r {
		mid := l + (r-l)/2
		if nums[mid] >= nums[r] {
			l = mid + 1
		} else {
			r = mid
		}
	}
	return nums[l]
}
func findMin1(nums []int) int {
	n := len(nums)
	l, r := 0, n-1
	for l <= r {
		mid := l + (r-l)/2
		if nums[(mid+n-1)%n] > nums[mid] {
			return nums[mid]
		} else if nums[mid] > nums[(mid+1)%n] {
			return nums[(mid+1)%n]
		} else if nums[mid] > nums[r] {
			l = mid + 1
		} else {
			r = mid - 1
		}
	}
	if l < n {
		return nums[l]
	}
	return -1
}
