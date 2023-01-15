package medium

func reverse(x int) int {
	var ans int64
	for x != 0 {
		ans = ans*10 + int64(x%10)
		if ans > 0x7fffffff || ans < -0x80000000 {
			return 0
		}
		x /= 10
	}
	return int(ans)
}
