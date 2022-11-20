package medium

import "sort"

func searchMatrix(matrix [][]int, target int) bool {

	m, n := len(matrix), len(matrix[0])
	x, y := 0, n-1
	for x < m && y >= 0 {
		if matrix[x][y] == target {
			return true
		} else if matrix[x][y] > target {
			y--
		} else if matrix[x][y] < target {
			x++
		}
	}
	return false
}

func searchMatrix1(matrix [][]int, target int) bool {

	for _, row := range matrix {
		idx := sort.SearchInts(row, target)
		if idx < len(row) && row[idx] == target {
			return true
		}
	}
	return false
}
