package lc

//leetcode submit region begin(Prohibit modification and deletion)
func trap(height []int) (sum int) {
	Max := func(x, y int) int {
		if x < y {
			return y
		}
		return x
	}
	n := len(height)
	l, r := 0, n-1
	var ans, lmax, rmax int
	for l <= r {
		lmax = Max(lmax, height[l])
		rmax = Max(rmax, height[r])
		if lmax < rmax {
			ans += lmax - height[l]
			l++
		} else {
			ans += rmax - height[r]
			r--
		}
	}
	return ans
}
func trap1(height []int) (sum int) {
	Max := func(x, y int) int {
		if x < y {
			return y
		}
		return x
	}
	Min := func(x, y int) int {
		if x < y {
			return x
		}
		return y
	}
	n := len(height)
	var ans int
	lmax, rmax := make([]int, n), make([]int, n)
	lmax[0] = height[0]
	rmax[n-1] = height[n-1]
	for i := 1; i < n; i++ {
		lmax[i] = Max(lmax[i-1], height[i])
	}
	for k := n - 2; k >= 0; k-- {
		rmax[k] = Max(rmax[k+1], height[k])
	}
	for i := 1; i < n-1; i++ {
		h := height[i]
		ans += Min(lmax[i], rmax[i]) - h
	}
	return ans
}
func trap2(height []int) (sum int) {
	Min := func(x, y int) int {
		if x < y {
			return x
		}
		return y
	}
	var stack []int
	for i := 0; i < len(height); i++ {
		curr := height[i]
		for len(stack) > 0 && curr > height[stack[len(stack)-1]] {
			v := height[stack[len(stack)-1]]
			stack = stack[:len(stack)-1]
			if len(stack) == 0 { //左边没柱子，不能积水
				break
			}
			distance := i - stack[len(stack)-1] - 1
			h := Min(curr, height[stack[len(stack)-1]])
			sum += distance * (h - v)
		}
		stack = append(stack, i)
	}
	return
}

//leetcode submit region end(Prohibit modification and deletion)
