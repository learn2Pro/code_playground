package medium

func rotate(matrix [][]int) {

	m := len(matrix)
	for i := 1; i < m; i++ {
		for j := i - 1; j >= 0; j-- {
			matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]
		}
	}

	for i := 0; i < m; i++ {
		for j := 0; j < m/2; j++ {
			matrix[i][j], matrix[i][m-j-1] = matrix[i][m-j-1], matrix[i][j]
		}
	}
}
