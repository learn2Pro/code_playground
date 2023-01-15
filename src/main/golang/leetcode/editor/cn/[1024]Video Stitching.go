package lc

import "sort"

//leetcode submit region begin(Prohibit modification and deletion)
func videoStitching(clips [][]int, time int) int {
	Max := func(x, y int) int {
		if x > y {
			return x
		}
		return y
	}
	sort.Slice(clips, func(i, j int) bool {
		if clips[i][0] == clips[j][0] {
			return clips[i][1] > clips[j][1]
		}
		return clips[i][0] < clips[j][0]
	})
	n := len(clips)
	var count = 0
	var i int
	var end0, end1 = 0, 0
	for i < n && clips[i][0] <= end0 {
		for i < n && clips[i][0] <= end0 {
			end1 = Max(end1, clips[i][1])
			i++
		}
		count++
		end0 = end1
		if end0 >= time {
			return count
		}
	}
	return -1
}

//leetcode submit region end(Prohibit modification and deletion)
