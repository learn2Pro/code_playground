package lc

//leetcode submit region begin(Prohibit modification and deletion)
func findErrorNums(nums []int) []int {
	Abs := func(x int) int {
		if x < 0 {
			return -x
		}
		return x
	}
	var dup, missing int
	for _, num := range nums {
		if nums[Abs(num)-1] < 0 {
			dup = Abs(num)
		} else {
			nums[Abs(num)-1] *= -1
		}
	}
	for i, num := range nums {
		if num > 0 {
			missing = i + 1
		}
	}
	return []int{dup, missing}
}
func findErrorNums1(nums []int) []int {
	var seed int
	for i, num := range nums {
		seed ^= i + 1 ^ num
	}
	sign := seed & -seed
	var ans0, ans1 int
	for i, num := range nums {
		if num&sign > 0 {
			ans0 ^= num
		} else {
			ans1 ^= num
		}
		if (i+1)&sign > 0 {
			ans0 ^= i + 1
		} else {
			ans1 ^= i + 1
		}
	}
	return []int{ans0, ans1}
}

//leetcode submit region end(Prohibit modification and deletion)
