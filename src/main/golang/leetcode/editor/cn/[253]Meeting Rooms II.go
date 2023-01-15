package lc

import "sort"

//leetcode submit region begin(Prohibit modification and deletion)
func minMeetingRooms(intervals [][]int) (ans int) {
	//sort.Slice(intervals, func(i, j int) bool {
	//	return intervals[i][1] < intervals[j][1]
	//})
	//var count = 1
	//n := len(intervals)
	//var end = intervals[0][1]
	//for i := 1; i < n; i++ {
	//	start := intervals[i][0]
	//	if start >= end {
	//		count++
	//		end = intervals[i][1]
	//	}
	//}
	//return n - count + 1
	n := len(intervals)
	var begin = make([]int, n)
	var end = make([]int, n)
	for i, interval := range intervals {
		begin[i] = interval[0]
		end[i] = interval[1]
	}
	sort.Ints(begin)
	sort.Ints(end)
	var i, j int
	var count int
	for i < n && j < n {
		if begin[i] < end[j] {
			count++
			i++
		} else {
			count--
			j++
		}
		if count > ans {
			ans = count
		}
	}
	return
}

//leetcode submit region end(Prohibit modification and deletion)
