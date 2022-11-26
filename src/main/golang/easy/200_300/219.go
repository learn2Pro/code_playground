package easy

func containsNearbyDuplicate(nums []int, k int) bool {
	win := make(map[int]int)
	for i := 0; i < len(nums); i++ {
		if _, ok := win[nums[i]]; ok {
			return true
		}
		if i >= k {
			delete(win, nums[i-k])
		}
		win[nums[i]]++
	}
	return false
}
func containsNearbyDuplicate1(nums []int, k int) bool {
	win := make(map[int]int)
	l, r := 0, 0
	var duplicateNums []int
	for r < len(nums) {
		win[nums[r]]++
		if win[nums[r]] >= 2 {
			duplicateNums = append(duplicateNums, nums[r])
		}
		r++
		for r-l > k+1 {
			if win[nums[l]] == 2 {
				duplicateNums = duplicateNums[1:]
			}
			win[nums[l]]--
			l++
		}
		if len(duplicateNums) > 0 {
			return true
		}
	}
	return false
}
