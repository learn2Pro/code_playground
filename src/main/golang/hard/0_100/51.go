package hard

func solveNQueens(n int) [][]string {

	var ans [][]string
	var isValid = func(track [][]rune, row, col int) bool {
		for i := row - 1; i >= 0; i-- { //check column
			if track[i][col] == 'Q' {
				return false
			}
		}
		for i, j := row-1, col-1; i >= 0 && j >= 0; i, j = i-1, j-1 {
			if track[i][j] == 'Q' {
				return false
			}
		}
		for i, j := row-1, col+1; i >= 0 && j < n; i, j = i-1, j+1 {
			if track[i][j] == 'Q' {
				return false
			}
		}
		return true
	}
	var backtrack func(row int, track [][]rune)
	backtrack = func(row int, track [][]rune) {
		if row == n {
			var item []string
			for _, runes := range track {
				item = append(item, string(runes))
			}
			ans = append(ans, item)
			return
		}
		for i := 0; i < n; i++ {
			if !isValid(track, row, i) {
				continue
			}
			track[row][i] = 'Q'
			backtrack(row+1, track)
			track[row][i] = '.'
		}
	}
	t := make([][]rune, n)
	for i := 0; i < n; i++ {
		t[i] = make([]rune, n)
		for j := 0; j < n; j++ {
			t[i][j] = '.'
		}
	}
	backtrack(0, t)
	return ans
}
