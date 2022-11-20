package medium

func longestSubarray(nums []int, limit int) int {
	Max := func(x, y int) int {
		if x > y {
			return x
		}
		return y
	}
	l, r := 0, 0
	var minQ, maxQ []int
	var ans int
	for r < len(nums) {
		v := nums[r]
		for len(minQ) > 0 && minQ[len(minQ)-1] > v {
			minQ = minQ[:len(minQ)-1]
		}
		minQ = append(minQ, v)
		for len(maxQ) > 0 && maxQ[len(maxQ)-1] < v {
			maxQ = maxQ[:len(maxQ)-1]
		}
		maxQ = append(maxQ, v)
		r++
		for len(minQ) > 0 && len(maxQ) > 0 && maxQ[0]-minQ[0] > limit {
			if nums[l] == minQ[0] {
				//update minimal
				minQ = minQ[1:]
			}
			if nums[l] == maxQ[0] {
				//update maximal
				maxQ = maxQ[1:]
			}
			l++
		}
		ans = Max(ans, r-l)
	}
	return ans
}
