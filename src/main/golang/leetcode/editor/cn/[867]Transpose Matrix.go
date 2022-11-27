package lc

//leetcode submit region begin(Prohibit modification and deletion)
func transpose(matrix [][]int) [][]int {
	m, n := len(matrix), len(matrix[0])
	ans := make([][]int, n)
	for i := 0; i < n; i++ {
		ans[i] = make([]int, m)
	}
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			ans[j][i] = matrix[i][j]
		}
	}
	return ans
}

//leetcode submit region end(Prohibit modification and deletion)
