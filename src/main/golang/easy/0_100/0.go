package easy

//1. Two Sum
func twoSum(nums []int, target int) []int {
	ans := make([]int, 2)
	previousHolder := make(map[int]int)
	for i, num := range nums {
		if idx, ok := previousHolder[target-num]; ok {
			ans[0] = idx
			ans[1] = i
			return ans
		}
		previousHolder[num] = i
	}
	return nil
}
