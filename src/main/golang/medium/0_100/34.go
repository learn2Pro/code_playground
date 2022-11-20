package medium

func searchRange(nums []int, target int) []int {

	leftBound := func() int {
		l, r := 0, len(nums)-1
		for l <= r {
			mid := l + (r-l)/2
			if nums[mid] == target {
				r = mid - 1
			} else if nums[mid] < target {
				l = mid + 1
			} else if nums[mid] > target {
				r = mid - 1
			}
		}
		if l == len(nums) || nums[l] != target {
			return -1
		} else {
			return l
		}
	}

	rightBound := func() int {
		l, r := 0, len(nums)-1
		for l <= r {
			mid := l + (r-l)/2
			if nums[mid] == target {
				l = mid + 1
			} else if nums[mid] < target {
				l = mid + 1
			} else if nums[mid] > target {
				r = mid - 1
			}
		}
		if r < 0 || nums[r] != target {
			return -1
		} else {
			return r
		}
	}
	return []int{leftBound(), rightBound()}
}
