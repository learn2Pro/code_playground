package medium

import "sort"

func triangleNumber(nums []int) int {
	sort.Ints(nums)
	var ans int
	for i := len(nums) - 1; i >= 2; i-- {
		l, m := 0, i-1
		for l < m {
			if nums[l]+nums[m] > nums[i] {
				ans += m - l
				m--
			} else {
				l++
			}
		}
	}
	return ans
}

func triangleNumber1(nums []int) int {
	sort.Ints(nums)
	var ans int
	for i := 0; i < len(nums); i++ {
		for j := i + 2; j < len(nums); j++ {
			l, r := i+1, j-1
			for l <= r {
				mid := l + (r-l)/2
				if nums[i]+nums[mid] > nums[j] {
					r = mid - 1
				} else {
					l = mid + 1
				}
			}
			ans += (j - l)
		}
	}
	return ans
}
