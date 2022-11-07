package medium

func permute(nums []int) [][]int {
	var ans [][]int
	var backtrack func(tracker []int, used []bool)
	backtrack = func(tracker []int, used []bool) {
		if len(tracker) == len(nums) {
			var item = make([]int, len(tracker))
			copy(item, tracker) //deep copy
			ans = append(ans, item)
		}
		for i, num := range nums {
			if used[i] {
				continue
			}
			tracker = append(tracker, num)
			used[i] = true
			backtrack(tracker, used)
			tracker = tracker[:len(tracker)-1]
			used[i] = false
		}
	}
	var t []int
	var u = make([]bool, len(nums))
	backtrack(t, u)
	return ans
}
