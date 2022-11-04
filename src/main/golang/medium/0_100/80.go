package medium

func removeDuplicates(nums []int) int {
	if len(nums) <= 2 {
		return len(nums)
	}
	slow, fast := 2, 2
	for fast < len(nums) {
		if nums[slow-2] != nums[fast] {
			nums[slow] = nums[fast]
			slow++
		}
		fast++
	}
	return slow
}

//func removeDuplicates(nums []int) int {
//	if len(nums) <= 1 {
//		return len(nums)
//	}
//	curr := 0
//	for curr < len(nums) {
//		if curr+1 < len(nums) && nums[curr] == nums[curr+1] {
//			x, i := nums[curr], curr+1
//			for ; i < len(nums) && nums[i] == x; i++ {
//			}
//			j := curr + 2
//			//swap
//			for i < len(nums) && j < len(nums) && nums[j] == x {
//				nums[i], nums[j] = nums[j], nums[i]
//				i++
//				j++
//			}
//			curr += 2
//			if curr < len(nums) && nums[curr] <= nums[curr-2] {
//				break
//			}
//		} else {
//			curr++
//			if curr < len(nums) && nums[curr-1] >= nums[curr] {
//				break
//			}
//		}
//	}
//	return curr
//}
