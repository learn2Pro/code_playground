package medium

import "sort"

func threeSum(nums []int) (ans [][]int) {
	sort.Ints(nums)
	l, r := 0, len(nums)-1
	for i := 1; i < len(nums)-1; i++ {
		target := -nums[i]
		for l < i && r > i {
			if nums[l]+nums[r] == target {
				ans = append(ans, []int{nums[l], nums[i], nums[r]})
				break
			} else if nums[l]+nums[r] < target {
				l++
			} else {
				r--
			}
		}
	}
	return
}
