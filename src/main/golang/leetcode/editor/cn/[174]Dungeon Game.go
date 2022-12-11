package lc

import "math"

//leetcode submit region begin(Prohibit modification and deletion)
func calculateMinimumHP(dungeon [][]int) int {
	Max := func(x, y int) int {
		if x > y {
			return x
		}
		return y
	}
	Min := func(x, y int) int {
		if x > y {
			return y
		}
		return x
	}
	m, n := len(dungeon), len(dungeon[0])
	dp := make([][]int, m+1)
	for i := 0; i < m+1; i++ {
		dp[i] = make([]int, n+1)
		for j := 0; j < n+1; j++ {
			dp[i][j] = math.MaxInt32
		}
	}
	dp[m][n-1], dp[m-1][n] = 1, 1
	for i := m - 1; i >= 0; i-- {
		for j := n - 1; j >= 0; j-- {
			minimal := Min(dp[i+1][j], dp[i][j+1])
			dp[i][j] = Max(1, minimal-dungeon[i][j])
		}
	}
	return dp[0][0]
}

//leetcode submit region end(Prohibit modification and deletion)
