package medium

import "sort"

func combinationSum2(candidates []int, target int) [][]int {

	var ans [][]int
	var tracker []int

	var backtrack func(begin, accumulator int)
	backtrack = func(begin, accumulator int) {
		if accumulator == target {
			var item = make([]int, len(tracker))
			copy(item, tracker)
			ans = append(ans, item)
			return
		}
		for i := begin; i < len(candidates); i++ {
			if accumulator+candidates[i] > target {
				break
			}
			if begin != i && candidates[i] == candidates[i-1] {
				continue
			}
			tracker = append(tracker, candidates[i])
			backtrack(i+1, accumulator+candidates[i])
			tracker = tracker[:len(tracker)-1]
		}
	}
	sort.Ints(candidates)
	backtrack(0, 0)
	return ans
}
