package easy

func searchInsert(nums []int, target int) int {
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
