package medium

import "sort"

//[1,1,2]
//[1,2,3]
//[3,3,0,3]
func permuteUnique(nums []int) [][]int {

	var tracker []int
	var ans [][]int
	n := len(nums)
	var used = make([]bool, n)
	var backtrack func()
	backtrack = func() {
		if len(tracker) == n {
			var item = make([]int, len(tracker))
			copy(item, tracker)
			ans = append(ans, item)
			return
		}
		pre := -11
		for i := 0; i < n; i++ {
			if used[i] || nums[i] == pre {
				continue
			}
			pre = nums[i]
			tracker, used[i] = append(tracker, nums[i]), true
			backtrack()
			tracker, used[i] = tracker[:len(tracker)-1], false
		}
	}
	sort.Ints(nums)
	backtrack()
	return ans
}

func permuteUnique1(nums []int) [][]int {

	var tracker []int
	var ans [][]int
	n := len(nums)
	var used = make([]bool, n)
	var backtrack func()
	backtrack = func() {
		if len(tracker) == n {
			var item = make([]int, len(tracker))
			copy(item, tracker)
			ans = append(ans, item)
			return
		}
		for i := 0; i < n; i++ {
			if used[i] {
				continue
			}
			if i != 0 && nums[i] == nums[i-1] && !used[i-1] {
				continue
			}
			tracker, used[i] = append(tracker, nums[i]), true
			backtrack()
			tracker, used[i] = tracker[:len(tracker)-1], false
		}
	}
	sort.Ints(nums)
	backtrack()
	return ans
}
