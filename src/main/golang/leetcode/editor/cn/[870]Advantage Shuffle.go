package lc

import "sort"

//leetcode submit region begin(Prohibit modification and deletion)
func advantageCount(nums1 []int, nums2 []int) []int {
	n := len(nums2)
	sort.Ints(nums1)
	ans := make([]int, n)
	nums3 := make([][]int, n)
	for i := 0; i < n; i++ {
		nums3[i] = []int{i, nums2[i]}
	}
	sort.Slice(nums3, func(i, j int) bool {
		return nums3[i][1] < nums3[j][1]
	})
	l, r := 0, n-1
	for i := n - 1; i >= 0; i-- {
		idx, num := nums3[i][0], nums3[i][1]
		if nums1[r] > num {
			ans[idx] = nums1[r]
			r--
		} else {
			ans[idx] = nums1[l]
			l++
		}
	}
	return ans
}

//leetcode submit region end(Prohibit modification and deletion)
