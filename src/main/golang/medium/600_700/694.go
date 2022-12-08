package medium

import (
	"strconv"
	"strings"
)

func numDistinctIslands(grid [][]int) int {
	m, n := len(grid), len(grid[0])
	var dfs func(path *[]string, i, j, dir int)
	dfs = func(path *[]string, i, j, dir int) {
		if i < 0 || j < 0 || i >= m || j >= n {
			return
		}
		if grid[i][j] == 0 {
			return
		}
		grid[i][j] = 0
		*path = append(*path, strconv.Itoa(dir))
		dfs(path, i+1, j, 1)
		dfs(path, i-1, j, 2)
		dfs(path, i, j+1, 3)
		dfs(path, i, j-1, 4)
		*path = append(*path, strconv.Itoa(-dir))
	}
	visited := make(map[string]bool)
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if grid[i][j] == 1 {
				var path []string
				dfs(&path, i, j, 0)
				visited[strings.Join(path, ",")] = true
			}
		}
	}
	return len(visited)
}
