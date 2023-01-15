package lc

//leetcode submit region begin(Prohibit modification and deletion)
func canPartitionKSubsets(nums []int, k int) bool {
	n := len(nums)
	if k > n {
		return false
	}
	var sum int
	for _, num := range nums {
		sum += num
	}
	if sum%k != 0 {
		return false
	}
	var used = 0
	var target = sum / k
	var memo = make(map[int]bool)
	var backtrack func(kk, bucket, start int) bool
	backtrack = func(kk, bucket, start int) bool {
		if kk == 0 {
			return true
		}
		if bucket == target {
			res := backtrack(kk-1, 0, 0)
			memo[used] = res
			return res
		}
		if v, ok := memo[used]; ok {
			return v
		}
		for i := start; i < n; i++ {
			if ((used >> i) & 1) == 1 {
				continue
			}
			if bucket+nums[i] > target {
				continue
			}
			used |= 1 << i
			if backtrack(kk, bucket+nums[i], i+1) {
				return true
			}
			used ^= 1 << i
		}
		return false
	}

	return backtrack(k, 0, 0)
}

//leetcode submit region end(Prohibit modification and deletion)
