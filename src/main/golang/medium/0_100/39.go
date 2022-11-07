package medium

func combinationSum(candidates []int, target int) [][]int {

	var ans [][]int
	var tracker []int
	var backtrack func(index, remain int)
	backtrack = func(index, remain int) {
		if remain == 0 {
			var item = make([]int, len(tracker))
			copy(item, tracker)
			ans = append(ans, item)
			return
		}
		for i := index; i < len(candidates); i++ {
			if candidates[i] > remain {
				continue
			}
			tracker = append(tracker, candidates[i])
			backtrack(i, remain-candidates[i])
			tracker = tracker[:len(tracker)-1]
		}
	}
	backtrack(0, target)
	return ans
}
