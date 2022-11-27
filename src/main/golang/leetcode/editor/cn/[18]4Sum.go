package lc

import "sort"

//leetcode submit region begin(Prohibit modification and deletion)
func fourSum(nums []int, target int) [][]int {
	sort.Ints(nums)
	n := len(nums)
	findTarget := func(start, target int) (ans [][]int) {
		l, r := start, n-1
		for l < r {
			left, right := nums[l], nums[r]
			sum := left + right
			if sum < target {
				for l < r && nums[l] == left {
					l++
				}
			} else if sum > target {
				for l < r && nums[r] == right {
					r--
				}
			} else {
				ans = append(ans, []int{left, right})
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

	var ans [][]int
	for i := 0; i < n; i++ {
		for j := i + 1; j < n; j++ {
			res := findTarget(j+1, target-nums[i]-nums[j])
			for _, item := range res {
				ans = append(ans, []int{nums[i], nums[j], item[0], item[1]})
			}
			for j < n-2 && nums[j+1] == nums[j] {
				j++
			}
		}
		for i < n-3 && nums[i+1] == nums[i] {
			i++
		}
	}
	return ans
}

//leetcode submit region end(Prohibit modification and deletion)
