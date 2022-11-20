package medium

func findDuplicate(nums []int) int {
	slow, fast := 0, 0
	for {
		slow = nums[slow]
		fast = nums[nums[fast]]
		if slow == fast {
			break
		}
	}
	slow = 0
	for slow != fast {
		slow = nums[slow]
		fast = nums[fast]
	}
	return slow
}

func findDuplicate3(nums []int) int {
	n, bit_max := len(nums), 31
	for ((n - 1) >> bit_max) == 0 {
		bit_max--
	}
	var ans int
	for j := 0; j <= bit_max; j++ {
		x, y := 0, 0
		for i := 0; i < n; i++ {
			if nums[i]&(1<<j) > 0 {
				x++
			}
			if i > 0 && (i&(1<<j)) > 0 {
				y++
			}
		}
		if x > y {
			ans |= 1 << j
		}
	}
	return ans
}
func findDuplicate2(nums []int) int {
	n := len(nums)
	l, r := 1, n
	for l < r {
		mid := l + (r-l)/2
		var cnt int
		for _, num := range nums {
			if num <= mid {
				cnt += 1
			}
		}
		if cnt <= mid {
			l = mid + 1
		} else {
			r = mid
		}
	}
	return l
}

func findDuplicate1(nums []int) int {
	visited := make(map[int]bool)
	for _, num := range nums {
		if _, ok := visited[num]; ok {
			return num
		}
		visited[num] = true
	}
	return -1
}
