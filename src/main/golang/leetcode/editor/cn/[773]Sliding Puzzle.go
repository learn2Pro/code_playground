package lc

import "strings"

//leetcode submit region begin(Prohibit modification and deletion)
func slidingPuzzle(board [][]int) int {
	neighbor := [][]int{{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}}
	var tracker []rune
	for i := 0; i < 2; i++ {
		for j := 0; j < 3; j++ {
			tracker = append(tracker, rune(board[i][j]+'0'))
		}
	}
	switchLoc := func(x string) (ret []string) {
		loc := strings.Index(x, "0")
		runes := []rune(x)
		for _, to := range neighbor[loc] {
			runes[loc], runes[to] = runes[to], runes[loc]
			ret = append(ret, string(runes))
			runes[loc], runes[to] = runes[to], runes[loc]
		}
		return
	}
	var q = []string{string(tracker)}
	var step = 0
	var visited = map[string]bool{string(tracker): true}
	for len(q) > 0 {
		var tmp []string
		for _, state := range q {
			if state == "123450" {
				return step
			}
			for _, neighbor := range switchLoc(state) {
				if _, ok := visited[neighbor]; ok {
					continue
				}
				visited[neighbor] = true
				tmp = append(tmp, neighbor)
			}
			q = tmp
		}
		step += 1
	}
	return -1
}

//leetcode submit region end(Prohibit modification and deletion)
