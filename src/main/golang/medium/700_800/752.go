package medium

func openLock(deadends []string, target string) int {
	plusOne := func(input string, i int) string {
		var chars = make([]rune, 4)
		for j, ele := range input {
			chars[j] = ele
		}
		if input[i] == '9' {
			chars[i] = '0'
		} else {
			chars[i] = rune(input[i]) + 1
		}
		return string(chars)
	}
	minusOne := func(input string, i int) string {
		var chars = make([]rune, 4)
		for j, ele := range input {
			chars[j] = ele
		}
		if input[i] == '0' {
			chars[i] = '9'
		} else {
			chars[i] = rune(input[i]) - 1
		}
		return string(chars)
	}
	q1, q2, deads := make(map[string]bool), make(map[string]bool), make(map[string]bool)
	visited := make(map[string]bool)
	for _, deadend := range deadends {
		deads[deadend] = true
	}
	q1["0000"] = true
	q2[target] = true
	step := 0
	for len(q1) > 0 && len(q2) > 0 {
		if len(q1) > len(q2) {
			q1, q2 = q2, q1
		}
		tmp := make(map[string]bool)
		for key, _ := range q1 {
			if _, ok := deads[key]; ok {
				continue
			}
			if _, ok := q2[key]; ok {
				return step
			}
			visited[key] = true
			for i := 0; i < 4; i++ {
				m := minusOne(key, i)
				if _, ok := visited[m]; !ok {
					tmp[m] = true
				}
				p := plusOne(key, i)
				if _, ok := visited[p]; !ok {
					tmp[p] = true
				}
			}
		}
		step++
		q1, q2 = q2, tmp
	}
	return -1
}
func openLock1(deadends []string, target string) int {
	plusOne := func(input string, i int) string {
		var chars = make([]rune, 4)
		for j, ele := range input {
			chars[j] = ele
		}
		if input[i] == '9' {
			chars[i] = '0'
		} else {
			chars[i] = rune(input[i]) + 1
		}
		return string(chars)
	}
	minusOne := func(input string, i int) string {
		var chars = make([]rune, 4)
		for j, ele := range input {
			chars[j] = ele
		}
		if input[i] == '0' {
			chars[i] = '9'
		} else {
			chars[i] = rune(input[i]) - 1
		}
		return string(chars)
	}
	var q []string
	var used = make(map[string]bool)
	var deads = make(map[string]bool)
	var step = 0
	for _, deadend := range deadends {
		deads[deadend] = true
	}
	q = append(q, "0000")
	used["0000"] = true
	for len(q) > 0 {
		size := len(q)
		for j := 0; j < size; j++ {
			head := q[0]
			q = q[1:]
			if _, ok := deads[head]; ok {
				continue
			}
			if head == target {
				return step
			}
			for i := 0; i < 4; i++ {
				m, p := minusOne(head, i), plusOne(head, i)
				if _, ok := used[m]; !ok {
					used[m] = true
					q = append(q, m)
				}
				if _, ok := used[p]; !ok {
					used[p] = true
					q = append(q, p)
				}
			}
		}
		step++
	}
	return -1
}
