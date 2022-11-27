package medium

import "math"

func findRepeatedDnaSequences2(s string) (ans []string) {
	getNum := func(char rune) (num int) {
		switch char {
		case 'A':
			num = 0
		case 'C':
			num = 1
		case 'G':
			num = 2
		case 'T':
			num = 3
		}
		return
	}
	R, L := 4, 10
	RL := int(math.Pow(float64(R), float64(L-1)))
	var whash int
	visited := make(map[int]int)
	for i, char := range s {
		num := getNum(char)
		whash = R*whash + num
		if i >= 9 {
			if v, _ := visited[whash]; v == 1 {
				ans = append(ans, s[i-9:i+1])
			}
			visited[whash] += 1
			whash -= getNum(rune(s[i-9])) * RL
		}
	}
	return
}
func findRepeatedDnaSequences1(s string) (ans []string) {
	visited := make(map[string]int)
	var window []rune
	for i, char := range s {
		window = append(window, char)
		if len(window) == 10 {
			part := string(window)
			if v, ok := visited[part]; ok && v == 1 {
				ans = append(ans, part)
			}
			visited[part] += 1
		}
		if i >= 9 {
			window = window[1:]
		}
	}
	return
}
