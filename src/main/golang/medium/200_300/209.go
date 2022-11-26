package medium

import (
	"math"
)

func minSubArrayLen(target int, nums []int) int {
	Min := func(x, y int) int {
		if x < y {
			return x
		}
		return y
	}
	n := len(nums)
	prefix := make([]int, n+1)
	for i := 1; i <= n; i++ {
		prefix[i] = prefix[i-1] + nums[i-1]
	}
	if prefix[len(prefix)-1] < target {
		return 0
	}
	var ans = math.MaxInt32
	for x := 0; x <= n; x++ {
		l, r := x+1, n+1
		for l < r {
			mid := l + (r-l)/2
			if prefix[mid]-prefix[x] >= target {
				r = mid
			} else {
				l = mid + 1
			}
		}
		if l != n+1 {
			ans = Min(ans, l-x)
		}
	}
	if ans == math.MaxInt32 {
		return 0
	}
	return ans
}
func minSubArrayLen1(target int, nums []int) int {
	Min := func(x, y int) int {
		if x < y {
			return x
		}
		return y
	}
	l, r := 0, 0
	current := 0
	var ans = math.MaxInt32
	for r < len(nums) {
		current += nums[r]
		r++
		for current >= target {
			ans = Min(ans, r-l)
			current -= nums[l]
			l++
		}
	}
	if ans == math.MaxInt32 {
		return 0
	}
	return ans
}
