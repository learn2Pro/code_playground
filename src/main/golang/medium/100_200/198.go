package medium

import "math"

func rob(nums []int) int {
	Max := func(x, y int) int {
		if x > y {
			return x
		}
		return y
	}
	dp_0, dp_1 := 0, math.MinInt32
	for _, num := range nums {
		dp_0, dp_1 = Max(dp_0, dp_1), Max(dp_0+num, dp_1)
	}
	return Max(dp_0, dp_1)
}
