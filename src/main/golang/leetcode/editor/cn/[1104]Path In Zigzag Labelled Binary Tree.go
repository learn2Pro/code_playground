package lc

import "math"

//leetcode submit region begin(Prohibit modification and deletion)
func pathInZigZagTree(label int) []int {
	pow := func(x, y int) int {
		return int(math.Pow(float64(x), float64(y)))
	}
	var step int
	var tmp = label
	for tmp > 1 {
		tmp /= 2
		step += 1
	}
	var ans = []int{label}
	for step > 0 {
		parent := label / 2
		min, max := pow(2, step-1), pow(2, step)-1
		if step%2 == 1 {
			label = min + max - parent
		} else {
			label = max - (parent - min)
		}
		ans = append(ans, label)
		step -= 1
	}
	for i, j := 0, len(ans)-1; i < j; i, j = i+1, j-1 {
		ans[i], ans[j] = ans[j], ans[i]
	}
	return ans
}

//leetcode submit region end(Prohibit modification and deletion)
