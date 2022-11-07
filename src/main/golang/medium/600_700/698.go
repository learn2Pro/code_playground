package medium

import "sort"

//[4, 3, 2, 3, 5,2, 1]
//4
//[129,17, 74, 57, 1421, 99,92, 285, 1276, 218, 1588,215, 369, 117, 153, 22]
//3
//[2,2,2,2,3,4,5]
//4
func canPartitionKSubsets(nums []int, k int) bool {
	sum := 0
	for _, num := range nums {
		sum += num
	}
	if sum%k != 0 {
		return false
	}
	sort.Ints(nums)
	n, per := len(nums), sum/k
	if nums[len(nums)-1] > per {
		return false
	}
	dp := make([]bool, 1<<n)
	currSum := make([]int, 1<<n)
	dp[0] = true
	for i := 0; i < len(dp); i++ {
		if !dp[i] {
			continue
		}
		for j := 0; j < len(nums); j++ {
			if currSum[i]+nums[j] > per {
				break
			}
			if i>>j&1 == 0 {
				next := i | 1<<j
				if !dp[next] {
					currSum[next] = (currSum[i] + nums[j]) % per
					dp[next] = true
				}
			}
		}
	}
	return dp[1<<n-1]
}

//func canPartitionKSubsets(nums []int, k int) bool {
//	sum := 0
//	for _, num := range nums {
//		sum += num
//	}
//	if sum%k != 0 {
//		return false
//	}
//	sort.Ints(nums)
//	n := len(nums) - 1
//	for i := 0; i < n/2; i++ {
//		nums[i], nums[n-i] = nums[n-i], nums[i]
//	}
//	if nums[0] > sum/k {
//		return false
//	}
//	used := make([]bool, len(nums))
//	var backtrack func(times, current, begin int) bool
//	backtrack = func(times, current, begin int) bool {
//		if current == sum/k {
//			return backtrack(times-1, 0, 0)
//		}
//		if times == 1 {
//			return true
//		}
//		for i := begin; i < len(nums); i++ {
//			if !used[i] && current+nums[i] <= sum/k {
//				used[i] = true
//				if backtrack(times, current+nums[i], begin+1) {
//					return true
//				}
//				used[i] = false
//			}
//		}
//		return false
//	}
//	return backtrack(k, 0, 0)
//}
