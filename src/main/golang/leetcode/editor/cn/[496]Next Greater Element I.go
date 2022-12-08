package lc

//leetcode submit region begin(Prohibit modification and deletion)
func nextGreaterElement(nums1 []int, nums2 []int) (ans []int) {
	var stack []int
	var tmap = make(map[int]int)
	n := len(nums2)
	for i := n - 1; i >= 0; i-- {
		for len(stack) > 0 && nums2[i] > stack[len(stack)-1] {
			stack = stack[:len(stack)-1]
		}
		if len(stack) == 0 {
			tmap[nums2[i]] = -1
		} else {
			tmap[nums2[i]] = stack[len(stack)-1]
		}
		stack = append(stack, nums2[i])
	}
	for _, num := range nums1 {
		ans = append(ans, tmap[num])
	}
	return
}

//leetcode submit region end(Prohibit modification and deletion)
