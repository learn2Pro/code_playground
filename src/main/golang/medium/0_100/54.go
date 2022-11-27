package medium

func spiralOrder(matrix [][]int) (res []int) {

	m, n := len(matrix), len(matrix[0])
	upper, lower := 0, m-1
	left, right := 0, n-1
	for len(res) < m*n {
		if upper <= lower { //left_upper->right_upper
			for i := left; i <= right; i++ {
				res = append(res, matrix[upper][i])
			}
			upper += 1
		}
		if left <= right { //right_upper->right_lower
			for i := upper; i <= lower; i++ {
				res = append(res, matrix[i][right])
			}
			right -= 1
		}
		if upper <= lower { //right_lower->left_lower
			for i := right; i >= left; i-- {
				res = append(res, matrix[lower][i])
			}
			lower -= 1
		}
		if left <= right { //left_lower->left_upper
			for i := lower; i >= upper; i-- {
				res = append(res, matrix[i][left])
			}
			left += 1
		}
	}
	return
}
