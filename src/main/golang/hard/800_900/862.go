package hard

import "math"

func shortestSubarray(nums []int, k int) int {
	Min := func(x, y int) int {
		if x < y {
			return x
		}
		return y
	}
	prefix := make([]int, len(nums)+1)
	for i := 1; i <= len(nums); i++ {
		prefix[i] = prefix[i-1] + nums[i-1]
	}
	var q []int
	var ans = math.MaxInt32
	for i, sum := range prefix {
		for len(q) > 0 && sum-prefix[q[0]] >= k {
			ans = Min(ans, i-q[0])
			q = q[1:]
		}
		for len(q) > 0 && prefix[q[len(q)-1]] >= sum {
			q = q[:len(q)-1]
		}
		q = append(q, i)
	}
	if ans == math.MaxInt32 {
		return -1
	}
	return ans
}
func shortestSubarray1(nums []int, k int) int {
	Min := func(x, y int) int {
		if x < y {
			return x
		}
		return y
	}
	var current = 0
	var ans = math.MaxInt32
	l, r := 0, 0
	for r < len(nums) {
		current += nums[r]
		r += 1
		for l < r && (current >= k || nums[l] < 0 || nums[r-1]+nums[l] < 0 || current < 0) {
			if current >= k {
				ans = Min(ans, r-l)
			}
			current -= nums[l]
			l++
		}
	}
	if ans == math.MaxInt32 {
		return -1
	}
	return ans
}
