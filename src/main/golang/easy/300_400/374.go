package easy

func guess(num int) int {
	return 0
}
func guessNumber(n int) int {
	l, r := 1, n
	for l <= r {
		mid := l + (r-l)/2
		res := guess(mid)
		if res == 0 {
			return mid
		} else if res > 0 {
			l = mid + 1
		} else {
			r = mid - 1
		}
	}
	return -1
}
