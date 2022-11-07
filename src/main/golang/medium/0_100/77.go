package medium

func combine(n int, k int) [][]int {
	var tracker []int
	var ans [][]int
	var backtrack func(begin int)
	backtrack = func(begin int) {
		if len(tracker) == k {
			var item = make([]int, len(tracker))
			copy(item, tracker)
			ans = append(ans, item)
			return
		}
		if len(tracker)+n-begin+1 < k {
			return
		}
		for i := begin; i <= n; i++ {
			tracker = append(tracker, i)
			backtrack(i + 1)
			tracker = tracker[:len(tracker)-1]
		}
	}
	backtrack(1)
	return ans
}
