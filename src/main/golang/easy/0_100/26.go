package easy

/**
 * 26. Remove Duplicates from Sorted Array
 */
// 0, 0, 1, 1, 1, 2, 2, 3, 3, 4
func removeDuplicates(nums []int) int {
	if len(nums) < 2 {
		return len(nums)
	}
	k := 0
	for i := 1; i < len(nums); i++ {
		if nums[k] != nums[i] {
			k++
			nums[k] = nums[i]
		}
	}
	return k + 1
}

var dummy = -101

//func removeDuplicates(nums []int) int {
//	ans := len(nums)
//	if ans < 2 {
//		return ans
//	}
//	last := dummy
//	// 0, 0, 1, 1, 1, 2, 2, 3, 3, 4
//	for i := 0; i < len(nums); i++ {
//		if nums[i] == last {
//			nums[i] = dummy
//			ans -= 1
//		} else {
//			last = nums[i]
//		}
//	}
//	for j := 0; j < len(nums); j++ {
//		if nums[j] == dummy {
//			if swap(j, nums) {
//				break
//			}
//		}
//	}
//	return ans
//}

/**
 * true = can early stop
 * false = swapped
 */
func swap(i int, nums []int) bool {
	for j := i + 1; j < len(nums); j++ {
		if nums[j] != dummy {
			nums[i] = nums[j]
			nums[j] = dummy
			return false
		}
	}
	return true
}
