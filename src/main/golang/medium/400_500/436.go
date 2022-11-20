package medium

import "sort"

func findRightInterval(intervals [][]int) []int {
	for i := range intervals {
		intervals[i] = append(intervals[i], i)
	}
	sort.Slice(intervals, func(i, j int) bool { return intervals[i][0] < intervals[j][0] })
	ans := make([]int, len(intervals))
	for _, interval := range intervals {
		_, end, idx := interval[0], interval[1], interval[2]
		j := sort.Search(len(intervals), func(i int) bool { return intervals[i][0] >= end })
		if j < len(intervals) {
			ans[idx] = intervals[j][2]
		} else {
			ans[idx] = -1
		}
	}
	return ans
}
