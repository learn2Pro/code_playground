package easy

//use string
//func isPalindrome(x int) bool {
//	if x < 0 {
//		return false
//	}
//	s := strconv.Itoa(x)
//	high := len(s) - 1
//	for i := 0; i < len(s)/2; i++ {
//		if s[i] != s[high-i] {
//			return false
//		}
//	}
//	return true
//}
//cast to long
func isPalindrome(x int) bool {
	if x < 0 {
		return false
	}
	if x < 10 {
		return true
	}
	l := x
	var r = 0
	for l > 0 {
		mod := l % 10
		r = r*10 + mod
		l /= 10
	}
	return r == x
}
