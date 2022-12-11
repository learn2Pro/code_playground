package lc

import "math"

//leetcode submit region begin(Prohibit modification and deletion)
func minFallingPathSum(matrix [][]int) int {
	Min := func(x, y int) int {
		if x > y {
			return y
		}
		return x
	}
	m, n := len(matrix), len(matrix[0])
	//dp := make([][]int, m+1)
	//dp[0] = make([]int, n)
	dp := make([]int, n)
	var ans = math.MaxInt32
	for i := 0; i < m; i++ {
		var pre = math.MaxInt32
		for j := 0; j < n; j++ {
			//j - 1/j/j + 1
			var minimal = math.MaxInt32
			if j-1 >= 0 {
				minimal = Min(minimal, pre)
			}
			if j+1 < n {
				minimal = Min(minimal, dp[j+1])
			}
			pre = dp[j]
			dp[j] = Min(minimal, dp[j]) + matrix[i][j]
			if i == m-1 {
				ans = Min(ans, dp[j])
			}

		}
	}
	return ans
}

//leetcode submit region end(Prohibit modification and deletion)
