package medium

func combinationSum3(k int, n int) [][]int {
	var tracker []int
	var ans [][]int
	var backtrack func(begin, target int)
	backtrack = func(begin, target int) {
		if len(tracker) >= k {
			if len(tracker) == k && target == n {
				var item = make([]int, len(tracker))
				copy(item, tracker)
				ans = append(ans, item)
			}
			return
		}
		for i := begin; i <= 9; i++ {
			if target+i > n {
				break
			}
			tracker = append(tracker, i)
			backtrack(i+1, target+i)
			tracker = tracker[:len(tracker)-1]
		}
	}
	backtrack(1, 0)
	return ans
}
