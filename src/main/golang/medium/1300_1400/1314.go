package medium

func matrixBlockSum(mat [][]int, k int) [][]int {
	Max := func(x, y int) int {
		if x > y {
			return x
		}
		return y
	}
	Min := func(x, y int) int {
		if x < y {
			return x
		}
		return y
	}
	m, n := len(mat), len(mat[0])
	prefix := make([][]int, m+1)
	prefix[0] = make([]int, n+1)
	for i := 1; i <= m; i++ {
		prefix[i] = make([]int, n+1)
		for j := 1; j <= n; j++ {
			prefix[i][j] = prefix[i-1][j] + prefix[i][j-1] + mat[i-1][j-1] - prefix[i-1][j-1]
		}
	}
	ans := make([][]int, m)
	for i := 0; i < m; i++ {
		ans[i] = make([]int, n)
		for j := 0; j < n; j++ {
			row1, col1, row2, col2 := Max(0, i-k), Max(0, j-k), Min(i+k, m-1), Min(j+k, n-1)
			ans[i][j] = prefix[row2+1][col2+1] - prefix[row2+1][col1] - prefix[row1][col2+1] + prefix[row1][col1]
		}
	}
	return ans
}
