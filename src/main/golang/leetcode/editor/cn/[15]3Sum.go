package lc

import "sort"

//leetcode submit region begin(Prohibit modification and deletion)
func threeSum(nums []int) (ans [][]int) {
	sort.Ints(nums)
	n := len(nums)
	findTarget := func(start, target int) (ans [][]int) {
		l, r := start, n-1
		for l < r {
			sum := nums[l] + nums[r]
			left, right := nums[l], nums[r]
			if sum < target {
				for l < r && nums[l] == left {
					l++
				}
			} else if sum > target {
				for l < r && nums[r] == right {
					r--
				}
			} else {
				ans = append(ans, []int{nums[l], nums[r]})
				for l < r && nums[l] == left {
					l++
				}
				for l < r && nums[r] == right {
					r--
				}
			}
		}
		return
	}

	for i := 0; i < n; i++ {
		res := findTarget(i+1, -nums[i])
		for _, slice := range res {
			ans = append(ans, []int{nums[i], slice[0], slice[1]})
		}
		for i < n-2 && nums[i+1] == nums[i] {
			i++
		}
	}
	return
}

//leetcode submit region end(Prohibit modification and deletion)
