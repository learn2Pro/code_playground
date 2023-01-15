package lc

import "sort"

//leetcode submit region begin(Prohibit modification and deletion)
func findMinArrowShots(points [][]int) int {
	sort.Slice(points, func(i, j int) bool {
		return points[i][1] < points[j][1]
	})
	var count = 1
	var end = points[0][1]
	for _, point := range points {
		if point[0] > end {
			count++
			end = point[1]
		}
	}
	return count
}

//leetcode submit region end(Prohibit modification and deletion)
