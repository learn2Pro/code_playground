package lc

//leetcode submit region begin(Prohibit modification and deletion)
func solve(board [][]byte) {
	//dfs
	//m, n := len(board), len(board[0])
	//var dfs func(i, j int, fill byte)
	//dfs = func(i, j int, fill byte) {
	//	if i < 0 || j < 0 || i >= m || j >= n {
	//		return
	//	}
	//	if board[i][j] == 'X' || board[i][j] == '#' {
	//		return
	//	}
	//	board[i][j] = fill
	//	dfs(i+1, j, fill)
	//	dfs(i-1, j, fill)
	//	dfs(i, j+1, fill)
	//	dfs(i, j-1, fill)
	//}
	//for i := 0; i < m; i++ {
	//	dfs(i, 0, '#')
	//	dfs(i, n-1, '#')
	//}
	//for j := 0; j < n; j++ {
	//	dfs(0, j, '#')
	//	dfs(m-1, j, '#')
	//}
	//for i := 0; i < m; i++ {
	//	for j := 0; j < n; j++ {
	//		if board[i][j] == 'O' {
	//			dfs(i, j, 'X')
	//		}
	//	}
	//}
	//for i := 0; i < m; i++ {
	//	for j := 0; j < n; j++ {
	//		if board[i][j] == '#' {
	//			board[i][j] = 'O'
	//		}
	//	}
	//}
	//union find
	m, n := len(board), len(board[0])
	parent := make([]int, m*n+1)
	for i := 0; i < m*n+1; i++ {
		parent[i] = i
	}
	var union func(p, q int)
	var find func(p int) int
	var connected func(p, q int) bool
	union = func(p, q int) {
		rootp, rootq := find(p), find(q)
		if rootp == rootq {
			return
		}
		parent[rootp] = rootq
	}
	find = func(p int) int {
		if parent[p] != p {
			parent[p] = find(parent[p])
		}
		return parent[p]
	}
	connected = func(p, q int) bool {
		rootp, rootq := find(p), find(q)
		return rootp == rootq
	}
	for i := 0; i < m; i++ {
		if board[i][0] == 'O' {
			union(i*n, m*n)
		}
		if board[i][n-1] == 'O' {
			union(i*n+n-1, m*n)
		}
	}
	for j := 0; j < n; j++ {
		if board[0][j] == 'O' {
			union(j, m*n)
		}
		if board[m-1][j] == 'O' {
			union((m-1)*n+j, m*n)
		}
	}
	shift := [][]int{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}
	for i := 1; i < m-1; i++ {
		for j := 1; j < n-1; j++ {
			if board[i][j] == 'O' {
				for _, tuple := range shift {
					x, y := i+tuple[0], j+tuple[1]
					if board[x][y] == 'O' {
						union(x*n+y, i*n+j)
					}
				}
			}
		}
	}
	for i := 1; i < m-1; i++ {
		for j := 1; j < n-1; j++ {
			if !connected(i*n+j, m*n) {
				board[i][j] = 'X'
			}
		}
	}
}

//leetcode submit region end(Prohibit modification and deletion)
