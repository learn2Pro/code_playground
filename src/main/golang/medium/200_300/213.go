package medium

import "math"

func rob(nums []int) int {
	Max := func(x, y int) int {
		if x > y {
			return x
		}
		return y
	}
	rob0 := func(start, end int) int {
		dp_0, dp_1 := 0, math.MinInt32
		for i := start; i <= end; i++ {
			dp_0, dp_1 = Max(dp_0, dp_1), Max(dp_1, dp_0+nums[i])
		}
		return Max(dp_0, dp_1)
	}
	n := len(nums)
	if n == 1 {
		return nums[0]
	} else if n == 2 {
		return Max(nums[0], nums[1])
	}
	return Max(rob0(0, len(nums)-2), rob0(1, len(nums)-1))
}
