package medium

import "math"

func minOperations(nums []int, x int) int {
	Max := func(x, y int) int {
		if x > y {
			return x
		}
		return y
	}
	var sum int
	for _, num := range nums {
		sum += num
	}
	if sum < x {
		return -1
	}
	l, r := 0, 0
	current := 0
	var ans = -1
	for r < len(nums) {
		current += nums[r]
		r++
		for current > sum-x {
			current -= nums[l]
			l++
		}
		if current == sum-x {
			ans = Max(ans, r-l)
		}
	}
	if ans < 0 {
		return ans
	}
	return len(nums) - ans
}
func minOperations1(nums []int, x int) int {

	n := len(nums)
	var ans = math.MaxInt32
	var backtrack func(i, j, remain, op int)
	backtrack = func(i, j, remain, op int) {
		if remain == 0 {
			if op < ans {
				ans = op
			}
			return
		}
		if i <= j && nums[i] <= x {
			backtrack(i+1, j, remain-nums[i], op+1)
		}
		if i <= j && nums[j] <= x {
			backtrack(i, j-1, remain-nums[j], op+1)
		}
	}
	backtrack(0, n-1, x, 0)
	if ans == math.MaxInt32 {
		return -1
	}
	return ans
}
