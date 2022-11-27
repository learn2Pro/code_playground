package lc

//leetcode submit region begin(Prohibit modification and deletion)
func smallestSubsequence(s string) string {
	vis, nums := make(map[rune]int), make(map[rune]int)
	for _, char := range s {
		nums[char]++
	}
	var stack []rune
	for _, char := range s {
		if v, ok := vis[char]; !ok || v == 0 {
			for len(stack) > 0 && stack[len(stack)-1] > char {
				c := stack[len(stack)-1]
				if nums[c] > 0 {
					vis[c] = 0
					stack = stack[:len(stack)-1]
				} else {
					break
				}
			}
			stack = append(stack, char)
			vis[char] = 1
		}
		nums[char]--
	}
	return string(stack)

}

//leetcode submit region end(Prohibit modification and deletion)
