package medium

func updateMatrix(mat [][]int) [][]int {
	move := [][]int{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}
	var q [][]int
	m, n := len(mat), len(mat[0])
	dist, visited := make([][]int, m), make([][]bool, m)
	for i := 0; i < m; i++ {
		dist[i], visited[i] = make([]int, n), make([]bool, n)
		for j := 0; j < n; j++ {
			if mat[i][j] == 0 {
				dist[i][j] = 0
				visited[i][j] = true
				q = append(q, []int{i, j})
			}
		}
	}
	for len(q) > 0 {
		head := q[0]
		i, j := head[0], head[1]
		for _, mm := range move {
			mi, mj := i+mm[0], j+mm[1]
			if mi >= 0 && mi < m && mj >= 0 && mj < n && !visited[mi][mj] {
				q = append(q, []int{mi, mj})
				visited[mi][mj] = true
				dist[mi][mj] = dist[i][j] + 1
			}
		}
		q = q[1:]
	}
	return dist
}

func updateMatrix0(mat [][]int) [][]int {
	Min := func(x, y int) int {
		if x < y {
			return x
		} else {
			return y
		}
	}
	m, n := len(mat), len(mat[0])
	maxVal := 10001
	dp := make([][]int, m)
	for i := 0; i < m; i++ {
		dp[i] = make([]int, n)
		for j := 0; j < n; j++ {
			if mat[i][j] == 0 { //init
				dp[i][j] = 0
			}
			if mat[i][j] == 1 && dp[i][j] == 0 { //init
				dp[i][j] = maxVal
			}
			if mat[i][j] == 1 {
				if i >= 1 {
					dp[i][j] = Min(dp[i][j], dp[i-1][j]+1)
				}
				if j >= 1 {
					dp[i][j] = Min(dp[i][j], dp[i][j-1]+1)
				}
			}
		}
	}
	for i := m - 1; i >= 0; i-- {
		for j := n - 1; j >= 0; j-- {
			if mat[i][j] == 1 {
				if i < m-1 {
					dp[i][j] = Min(dp[i][j], dp[i+1][j]+1)
				}
				if j < n-1 {
					dp[i][j] = Min(dp[i][j], dp[i][j+1]+1)
				}
			}
		}
	}
	return dp
}
