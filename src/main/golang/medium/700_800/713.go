package medium

func numSubarrayProductLessThanK(nums []int, k int) (ans int) {
	Max := func(x, y int) int {
		if x > y {
			return x
		}
		return y
	}
	var current = 1
	l, r := 0, 0
	for r < len(nums) {
		current *= nums[r]
		r += 1
		for current >= k && l < r {
			current = Max(1, current/nums[l])
			l++
		}
		if current < k {
			ans += (r - l)
		}
	}
	return
}
