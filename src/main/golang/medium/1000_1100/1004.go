package medium

func longestOnes(nums []int, k int) int {
	Max := func(x, y int) int {
		if x > y {
			return x
		}
		return y
	}
	l, r := 0, 0
	zero := 0
	var ans int
	for r < len(nums) {
		if nums[r] == 0 {
			zero++
		}
		for zero > k {
			if nums[l] == 0 {
				zero--
			}
			l++
		}
		r += 1
		ans = Max(ans, r-l)
	}
	return ans
}
func longestOnes1(nums []int, k int) int {
	Max := func(x, y int) int {
		if x > y {
			return x
		}
		return y
	}
	l, r := 0, 0
	var flipped []int
	var ans int
	for r < len(nums) {
		if nums[r] == 0 {
			if len(flipped) < k {
				flipped = append(flipped, r)
			} else if len(flipped) == k {
				if len(flipped) > 0 {
					l, flipped, r = flipped[0]+1, flipped[1:], r-1
				} else {
					l = r + 1
				}
			}
		}
		r += 1
		ans = Max(ans, r-l)
	}
	return ans
}
