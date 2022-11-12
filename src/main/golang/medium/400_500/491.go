package medium

func findSubsequences(nums []int) [][]int {

	var tracker []int
	var ans [][]int

	var backtrack func(begin int)
	backtrack = func(begin int) {
		if len(tracker) >= 2 {
			var item = make([]int, len(tracker))
			copy(item, tracker)
			ans = append(ans, item)
		}
		seen := make(map[int]bool)
		for i := begin; i < len(nums); i++ {
			if len(tracker) > 0 && nums[i] < tracker[len(tracker)-1] {
				continue
			}
			if _, ok := seen[nums[i]]; ok {
				continue
			}
			seen[nums[i]] = true
			tracker = append(tracker, nums[i])
			backtrack(i + 1)
			tracker = tracker[:len(tracker)-1]
		}
	}
	backtrack(0) //-100 <= nums[i] <= 100
	return ans
}
