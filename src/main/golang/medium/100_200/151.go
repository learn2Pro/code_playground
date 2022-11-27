package medium

import "strings"

func reverseWords(s string) (res string) {
	s = " " + s + " "
	l, r := len(s)-1, len(s)-1
	for i := len(s) - 2; i >= 0; i-- {
		if s[i] == ' ' {
			l, r = i, l
			if r > l+1 {
				res = res + s[l+1:r] + " "
			}
		}
	}
	return res[:len(res)-1]

}
func reverseWords1(s string) string {
	strings.Trim(s, " ")
	reverse0 := func(input []rune) string {
		l, r := 0, len(input)
		for l < r {
			input[l], input[r] = input[r], input[l]
			l, r = l+1, r-1
		}
		return string(input)
	}
	for _, item := range strings.Split(s, " ") {
		chars := []rune(item)
		reverse0(chars)
	}
	return ""
}
