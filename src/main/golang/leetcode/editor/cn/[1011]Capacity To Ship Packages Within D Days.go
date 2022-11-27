package lc

//leetcode submit region begin(Prohibit modification and deletion)
func shipWithinDays(weights []int, days int) int {
	Max := func(x, y int) int {
		if x > y {
			return x
		}
		return y
	}
	CanShip := func(capacity int) bool {
		var curr, dayCost int
		for _, weight := range weights {
			if curr+weight <= capacity {
				curr += weight
			} else {
				dayCost += 1
				curr = weight
			}
		}
		return dayCost <= days-1
	}
	m, sum := 0, 0
	for _, weight := range weights {
		m = Max(m, weight)
		sum += weight
	}
	l, r := m, sum+1
	for l < r {
		mid := l + (r-l)/2
		if !CanShip(mid) {
			l = mid + 1
		} else {
			r = mid
		}
	}
	return l
}

//leetcode submit region end(Prohibit modification and deletion)
