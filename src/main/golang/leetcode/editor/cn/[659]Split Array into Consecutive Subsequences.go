package lc

//leetcode submit region begin(Prohibit modification and deletion)
func isPossible(nums []int) bool {
	freq, need := make(map[int]int), make(map[int]int)
	for _, num := range nums {
		freq[num]++
	}
	for _, num := range nums {
		if freq[num] == 0 {
			continue
		}
		if need[num] > 0 {
			freq[num]--
			need[num]--
			need[num+1]++
		} else if freq[num] > 0 && freq[num+1] > 0 && freq[num+2] > 0 {
			freq[num]--
			freq[num+1]--
			freq[num+2]--
			need[num+3]++
		} else {
			return false
		}
	}
	return true
}

//leetcode submit region end(Prohibit modification and deletion)
