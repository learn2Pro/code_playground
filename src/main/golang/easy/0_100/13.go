package easy

//13. Roman to Integer
func romanToInt(s string) int {
	lookup := map[string]int{
		"I":  1,
		"IV": 4,
		"V":  5,
		"IX": 9,
		"X":  10,
		"XL": 40,
		"L":  50,
		"XC": 90,
		"C":  100,
		"CD": 400,
		"D":  500,
		"CM": 900,
		"M":  1000,
	}
	l := len(s)
	ans := 0
	for i := 0; i < l; {
		if i+1 < l {
			item, ok := lookup[s[i:i+2]]
			if ok {
				ans += item
				i += 2
				continue
			}
		}
		ans += lookup[s[i:i+1]]
		i += 1
	}
	return ans
}
func romanToInt1(s string) int {
	result := 0
	i := 0
	runes := []rune(s)
	for i < len(s) {
		switch runes[i] {
		case 'I':
			if checkSpecialCase(runes, i+1, 'V') {
				result += 4
				i++
			} else if checkSpecialCase(runes, i+1, 'X') {
				result += 9
				i++
			} else {
				result += 1
			}
		case 'V':
			result += 5
		case 'X':
			if checkSpecialCase(runes, i+1, 'L') {
				result += 40
				i++
			} else if checkSpecialCase(runes, i+1, 'C') {
				result += 90
				i++
			} else {
				result += 10
			}
		case 'L':
			result += 50
		case 'C':
			if checkSpecialCase(runes, i+1, 'D') {
				result += 400
				i++
			} else if checkSpecialCase(runes, i+1, 'M') {
				result += 900
				i++
			} else {
				result += 100
			}
		case 'D':
			result += 500
		case 'M':
			result += 1000
		}
		i++
	}
	return result
}

func checkSpecialCase(s []rune, nextIndex int, special rune) bool {
	if nextIndex == len(s) {
		return false
	}
	return s[nextIndex] == special
}
