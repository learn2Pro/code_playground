package medium

func searchMatrix(matrix [][]int, target int) bool {
	m, n := len(matrix), len(matrix[0])
	l, r := 0, m*n-1
	for l <= r {
		mid := l + (r-l)/2
		x, y := mid/n, mid%n
		if matrix[x][y] == target {
			return true
		} else if matrix[x][y] < target {
			l = mid + 1
		} else {
			r = mid - 1
		}
	}
	return false
}
