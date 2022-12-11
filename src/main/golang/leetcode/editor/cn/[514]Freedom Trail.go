package lc

import "math"

//leetcode submit region begin(Prohibit modification and deletion)
func findRotateSteps(ring string, key string) int {
	Abs := func(x int) int {
		if x < 0 {
			return -x
		}
		return x
	}
	Min := func(x ...int) int {
		var res = math.MaxInt32
		for _, n := range x {
			if n < res {
				res = n
			}
		}
		return res
	}
	m, n := len(key), len(ring)
	dp := make([][]int, m)
	for i := 0; i < m; i++ {
		dp[i] = make([]int, n)
		for j := 0; j < n; j++ {
			dp[i][j] = math.MaxInt32
		}
	}

	indexes := make(map[byte][]int)
	for i := 0; i < len(ring); i++ {
		indexes[ring[i]] = append(indexes[ring[i]], i)
	}
	for _, c := range indexes[key[0]] {
		dp[0][c] = Min(c, n-c) + 1 //Min(0->c,c->0)
	}
	for i := 1; i < m; i++ {
		for _, j := range indexes[key[i]] {
			for _, k := range indexes[key[i-1]] {
				dp[i][j] = Min(dp[i][j], dp[i-1][k]+Min(Abs(j-k), n-Abs(j-k))+1)
			}
		}
	}
	return Min(dp[m-1]...)
}

//leetcode submit region end(Prohibit modification and deletion)
