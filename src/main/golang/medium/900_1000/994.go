package medium

func orangesRotting(grid [][]int) int {
	move := [][]int{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}
	remain, step := 0, 0
	var q [][]int
	m, n := len(grid), len(grid[0])
	visited := make([][]bool, m)
	for i := 0; i < m; i++ {
		visited[i] = make([]bool, n)
		for j := 0; j < n; j++ {
			if grid[i][j] == 1 {
				remain += 1
			}
			if grid[i][j] == 2 {
				visited[i][j] = true
				q = append(q, []int{i, j})
			}
		}
	}
	for len(q) > 0 {
		var size = len(q)
		if remain == 0 {
			return step
		}
		for i := 0; i < size; i++ {
			curr := q[i]
			for _, mn := range move {
				mi, nj := curr[0]+mn[0], curr[1]+mn[1]
				if mi >= 0 && mi < m && nj >= 0 && nj < n && !visited[mi][nj] {
					visited[mi][nj] = true
					if grid[mi][nj] == 1 {
						q = append(q, []int{mi, nj})
						remain -= 1
					}
				}
			}
		}
		q = q[size:]
		step++
	}
	if remain == 0 {
		return step
	} else {
		return -1
	}
}
