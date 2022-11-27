package lc

//leetcode submit region begin(Prohibit modification and deletion)
func generateMatrix(n int) [][]int {
	upper, lower := 0, n-1
	left, right := 0, n-1
	matrix := make([][]int, n)
	for i := 0; i < n; i++ {
		matrix[i] = make([]int, n)
	}
	var curr = 1
	for curr <= n*n {
		if upper <= lower {
			for i := left; i <= right; i++ {
				matrix[upper][i] = curr
				curr++
			}
			upper += 1
		}
		if left <= right {
			for i := upper; i <= lower; i++ {
				matrix[i][right] = curr
				curr++
			}
			right -= 1
		}
		if upper <= lower {
			for i := right; i >= left; i-- {
				matrix[lower][i] = curr
				curr++
			}
			lower -= 1
		}
		if left <= right {
			for i := lower; i >= upper; i-- {
				matrix[i][left] = curr
				curr++
			}
			left += 1
		}
	}
	return matrix
}

//leetcode submit region end(Prohibit modification and deletion)
