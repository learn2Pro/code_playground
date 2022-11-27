package medium

import "sort"

func diagonalSort(mat [][]int) (ans [][]int) {
	m, n := len(mat), len(mat[0])
	ans = make([][]int, m)
	for i := 0; i < m; i++ {
		ans[i] = make([]int, n)
	}
	for i := 0; i < m; i++ {
		var res []int
		for j := 0; i+j < m && j < n; j++ {
			row, col := i+j, j
			res = append(res, mat[row][col])
		}
		sort.Ints(res)
		for j := 0; i+j < m && j < n; j++ {
			row, col := i+j, j
			ans[row][col] = res[j]
		}
	}
	for i := 1; i < n; i++ {
		var res []int
		for j := 0; j < m && i+j < n; j++ {
			row, col := j, i+j
			res = append(res, mat[row][col])
		}
		sort.Ints(res)
		for j := 0; j < m && i+j < n; j++ {
			row, col := j, i+j
			ans[row][col] = res[j]
		}
	}
	return ans
}
