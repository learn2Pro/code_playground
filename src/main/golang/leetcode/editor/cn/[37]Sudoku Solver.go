package lc

//leetcode submit region begin(Prohibit modification and deletion)
func solveSudoku(board [][]byte) {
	m, n := 9, 9
	isValid := func(b byte, i, j int) bool {
		for k := 0; k < 9; k++ {
			if board[k][j] == b {
				return false
			}
			if board[i][k] == b {
				return false
			}
			if board[(i/3)*3+k/3][(j/3)*3+k%3] == b {
				return false
			}
		}
		return true
	}
	var backtrack func(i, j int) bool
	backtrack = func(i, j int) bool {
		if i == m {
			return true
		}
		if j == n {
			return backtrack(i+1, 0)
		}
		if board[i][j] != '.' {
			return backtrack(i, j+1)
		}
		for k := 1; k <= 9; k++ {
			if !isValid(byte(k+'0'), i, j) {
				continue
			}
			board[i][j] = byte(k + '0')
			if backtrack(i, j+1) {
				return true
			}
			board[i][j] = '.'
		}
		return false
	}
	backtrack(0, 0)
}

//leetcode submit region end(Prohibit modification and deletion)
