package hard

func findMin(nums []int) int {
	l, r := 0, len(nums)-1
	var mid int
	for l <= r {
		mid = l + (r-l)/2
		if nums[mid] < nums[r] {
			r = mid
		} else if nums[mid] > nums[r] {
			l = mid + 1
		} else {
			r--
		}
	}
	return nums[l]
}
func findMin1(nums []int) int {
	for i := 1; i < len(nums); i++ {
		if nums[i] < nums[i-1] {
			return nums[i]
		}
	}
	return nums[0]
}
