package lc

import "sort"

//leetcode submit region begin(Prohibit modification and deletion)
func eraseOverlapIntervals(intervals [][]int) int {
	sort.Slice(intervals, func(i, j int) bool {
		return intervals[i][1] < intervals[j][1]
	})
	n := len(intervals)
	var count = 1
	var end = intervals[0][1]
	for _, interval := range intervals {
		if interval[0] >= end {
			count++
			end = interval[1]
		}
	}
	return n - count
}

//leetcode submit region end(Prohibit modification and deletion)
