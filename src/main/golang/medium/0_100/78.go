package medium

func subsets(nums []int) [][]int {

	n := len(nums)
	var ans [][]int
	var tracker []int
	var backtrack func(begin int)
	backtrack = func(begin int) {
		var item = make([]int, len(tracker))
		copy(item, tracker)
		ans = append(ans, item)
		for i := begin; i < n; i++ {
			tracker = append(tracker, nums[i])
			backtrack(i+1)
			tracker = tracker[:len(tracker)-1]
		}
	}
	backtrack(0)
	return ans
}
