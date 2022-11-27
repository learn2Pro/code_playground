package lc

//leetcode submit region begin(Prohibit modification and deletion)
func twoSum1(numbers []int, target int) []int {
	l, r := 0, len(numbers)-1
	for l < r {
		sum := numbers[l] + numbers[r]
		if sum == target {
			return []int{l + 1, r + 1}
		} else if sum < target {
			l++
		} else {
			r--
		}
	}
	return nil
}

//leetcode submit region end(Prohibit modification and deletion)
