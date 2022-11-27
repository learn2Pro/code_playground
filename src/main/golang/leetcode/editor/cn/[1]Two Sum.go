package lc

//leetcode submit region begin(Prohibit modification and deletion)
func twoSum(nums []int, target int) []int {
	mapper := make(map[int]int)
	for i, num := range nums {
		if v, ok := mapper[target-num]; ok {
			return []int{v, i}
		}
		mapper[num] = i
	}
	return nil
}

//leetcode submit region end(Prohibit modification and deletion)
