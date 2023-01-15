package lc

//leetcode submit region begin(Prohibit modification and deletion)
func superPow(a int, b []int) int {
	var mod = 1337
	//normalPow := func(x, y int) int {
	//	var ans = 1
	//	for i := 0; i < y; i++ {
	//		ans = (ans * x) % mod
	//	}
	//	return ans
	//}
	var normalPow func(x, y int) int
	normalPow = func(x, y int) int {
		if y == 0 {
			return 1
		}
		if y%2 == 1 {
			return (x * normalPow(x, y-1)) % mod
		} else {
			var sub = normalPow(x, y/2)
			return (sub * sub) % mod
		}
	}
	if len(b) == 0 {
		return 1
	}
	last, b := b[len(b)-1], b[:len(b)-1]
	return (normalPow(a, last) * normalPow(superPow(a, b), 10)) % mod
}

//leetcode submit region end(Prohibit modification and deletion)
