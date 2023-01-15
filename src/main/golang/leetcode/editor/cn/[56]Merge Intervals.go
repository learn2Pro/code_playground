package lc

import "sort"

//leetcode submit region begin(Prohibit modification and deletion)
func merge(intervals [][]int) [][]int {
	sort.Slice(intervals, func(i, j int) bool {
		if intervals[i][0] == intervals[j][0] {
			return intervals[i][1] > intervals[j][1]
		}
		return intervals[i][0] < intervals[j][0]
	})
	left, right := intervals[0][0], intervals[0][1]
	var ans [][]int
	for i := 1; i < len(intervals); i++ {
		if right >= intervals[i][0] && right <= intervals[i][1] {
			right = intervals[i][1]
		}
		if right < intervals[i][0] {
			ans = append(ans, []int{left, right})
			left, right = intervals[i][0], intervals[i][1]
		}
	}
	ans = append(ans, []int{left, right})
	return ans
}

//leetcode submit region end(Prohibit modification and deletion)
