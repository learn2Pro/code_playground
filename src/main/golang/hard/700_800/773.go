package hard

import "strings"

func slidingPuzzle(board [][]int) int {

	neighbor := [][]int{{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}}
	target := "123450"
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
	curr := make([]rune, 0, 6)
	for _, ints := range board {
		for _, v := range ints {
			curr = append(curr, '0'+rune(v))
		}
	}
	var start = string(curr)
	var q = []string{start}
	var visited = map[string]bool{start: true}
	step := 0
	for len(q) > 0 {
		var size = len(q)
		var tmp []string
		for i := 0; i < size; i++ {
			if q[i] == target {
				return step
			}
			for _, next := range switchLoc(q[i]) {
				if !visited[next] {
					visited[next] = true
					tmp = append(tmp, next)
				}
			}
		}
		step++
		q = tmp
	}
	return -1

}
