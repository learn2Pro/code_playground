package medium

import "sort"

//[10,9,2,5,3,7,101,18]
//[0,1,0,3,2,3]
//[7,7,7,7,7,7,7]
//[3,5,6,2,5,4,19,5,6,7,12]

func lengthOfLIS(nums []int) int {
	var ans []int
	for i := 0; i < len(nums); i++ {
		idx := sort.SearchInts(ans, nums[i])
		if idx >= len(ans) {
			ans = append(ans, nums[i])
		} else {
			ans[idx] = nums[i]
		}
	}
	return len(ans)
}
func lengthOfLIS2(nums []int) int {
	size := 1
	dp := make([]int, len(nums)+1)
	dp[1] = nums[0]
	for i := 1; i < len(nums); i++ {
		if nums[i] > dp[size] {
			size++
			dp[size] = nums[i]
		} else {
			l, r := 1, size
			for l <= r {
				mid := l + (r-l)/2
				if dp[mid] < nums[i] {
					l = mid + 1
				} else {
					r = mid - 1
				}
			}
			dp[l] = nums[i]
		}
	}
	return size
}

func lengthOfLIS1(nums []int) int {
	Max := func(x, y int) int {
		if x > y {
			return x
		}
		return y
	}
	n := len(nums)
	dp := make([]int, n)
	dp[0] = 1
	ans := 1
	for i := 1; i < n; i++ {
		dp[i] = 1
		for j := 0; j < i; j++ {
			if nums[i] > nums[j] {
				dp[i] = Max(dp[i], dp[j]+1)
			}
		}
		ans = Max(ans, dp[i])
	}
	return ans
}
