package medium

func search2(nums []int, target int) bool {
	n := len(nums)
	l, r := 0, 0
	for l < len(nums)-1 && nums[l] <= nums[l+1] {
		l++
	}
	l, r = l+1, l+n
	for l <= r {
		mid := l + (r-l)/2
		if nums[mid%n] == target {
			return true
		} else if nums[mid%n] < target {
			l = mid + 1
		} else if nums[mid%n] > target {
			r = mid - 1
		}
	}
	return false
}

func search1(nums []int, target int) bool {
	l, r := 0, len(nums)-1
	for l <= r {
		mid := l + (r-l)/2
		if nums[mid] == target {
			return true
		} else if nums[l] == nums[mid] && nums[mid] == nums[r] {
			l += 1
			r -= 1
		} else if nums[l] <= nums[mid] {
			if nums[mid] > target && nums[l] <= target {
				r = mid - 1
			} else {
				l = mid + 1
			}
		} else {
			if nums[mid] < target && nums[r] >= target {
				l = mid + 1
			} else {
				r = mid - 1
			}
		}
	}
	return false
}
