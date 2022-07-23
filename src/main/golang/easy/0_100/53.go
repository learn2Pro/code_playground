package easy

//[-2,1,-3,4,-1,2,1,-5,4]
//[1]
//[5,4,-1,7,8]
//[10]
//[-10,-10,-1,-1,-1]
//[1,2,-1,-2,2,1,-2,1]
//53. 最大子数组和
type State struct {
	lSum int
	rSum int
	mSum int
	iSum int
}

func pushUp(s1, s2 State) State {
	return State{
		lSum: Max(s1.lSum, s2.lSum+s1.iSum),
		rSum: Max(s2.rSum, s1.rSum+s2.iSum),
		mSum: Max(Max(s1.mSum, s2.mSum), s1.rSum+s2.lSum),
		iSum: s1.iSum + s2.iSum,
	}
}
func getRange(nums []int, l, r int) State {
	if l == r {
		return State{lSum: nums[l], rSum: nums[l], mSum: nums[l], iSum: nums[l]}
	}
	mid := (l + r) >> 1
	s1 := getRange(nums, l, mid)
	s2 := getRange(nums, mid+1, r)
	return pushUp(s1, s2)
}
func maxSubArray(nums []int) int {
	if len(nums) < 1 {
		return 0
	}
	return getRange(nums, 0, len(nums)-1).mSum
}

//=========================>dp O(n)=========================>
//func maxSubArray(nums []int) int {
//	if len(nums) < 1 {
//		return 0
//	}
//	max, dp := -0x7fffffff, -0x7fffffff
//	for _, num := range nums {
//		dp = Max(dp+num, num)
//		max = Max(max, dp)
//	}
//	return max
//}

//=========================>dp O(n^2)=========================>
//func maxSubArray(nums []int) int {
//	if len(nums) < 1 {
//		return 0
//	}
//	max := -0x7fffffff
//	for e := len(nums); e > 0; e-- {
//		dp := 0
//		for s := e - 1; s >= 0; s-- {
//			dp = dp + nums[s]
//			max = Max(dp, max)
//		}
//	}
//	return max
//}
func Max(a, b int) int {
	if a >= b {
		return a
	} else {
		return b
	}
}
