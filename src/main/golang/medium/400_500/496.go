package medium

func nextGreaterElement(nums1 []int, nums2 []int) (ans []int) {
	tmap := make(map[int]int)
	var stack []int
	for i := len(nums2) - 1; i >= 0; i-- {
		num := nums2[i]
		for len(stack) > 0 && stack[len(stack)-1] < num {
			stack = stack[:len(stack)-1]
		}
		if len(stack) > 0 {
			tmap[num] = stack[len(stack)-1]
		} else {
			tmap[num] = -1
		}
		stack = append(stack, num)
	}
	for _, num := range nums1 {
		ans = append(ans, tmap[num])
	}
	return
}
func nextGreaterElement1(nums1 []int, nums2 []int) (ans []int) {

	tmap := make(map[int]int)
	for i := 0; i < len(nums2); i++ {
		curr := nums2[i]
		for j := i + 1; j < len(nums2); j++ {
			if nums2[j] > curr {
				tmap[curr] = nums2[j]
				break
			}
		}
	}
	for _, num := range nums1 {
		if v, ok := tmap[num]; ok {
			ans = append(ans, v)
		} else {
			ans = append(ans, -1)
		}
	}
	return
}
