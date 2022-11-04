package medium

import "math"

//3
//2
//3
//5
//4
//2
//3
//4
//5
//2
//11
//13
//1000000000
//2
//217983653
//336916467
func nthUglyNumber(n int, a int, b int, c int) int {
	var gcd func(x, y int64) int64
	var lcm func(x, y int64) int64
	gcd = func(x, y int64) int64 {
		if y == 0 {
			return x
		} else {
			return gcd(y, x%y)
		}
	}
	lcm = func(x, y int64) int64 {
		return x * y / gcd(x, y)
	}
	min := func(x, y int) int {
		if x < y {
			return x
		} else {
			return y
		}
	}
	ab, ac, bc := lcm(int64(a), int64(b)), lcm(int64(a), int64(c)), lcm(int64(b), int64(c))
	abc := lcm(ab, int64(c))
	left, right := min(min(a, b), c)-1, int(2*math.Pow(10, 9)+1)
	for left < right {
		mid := (left + right) >> 1
		count := int64(mid/a) + int64(mid/b) + int64(mid/c) - int64(mid)/ab - int64(mid)/ac - int64(mid)/bc + int64(mid)/abc
		if count < int64(n) {
			left = mid + 1
		} else {
			right = mid
		}
	}
	return right
}

//func nthUglyNumber(n int, a int, b int, c int) int {
//	min := func(x, y int) int {
//		if x < y {
//			return x
//		} else {
//			return y
//		}
//	}
//	dp := 1
//	p1, p2, p3 := 1, 1, 1
//	for i := 2; i <= n+1; i++ {
//		num := min(min(p1*a, p2*b), p3*c)
//		if num == p1*a {
//			p1++
//		}
//		if num == p2*b {
//			p2++
//		}
//		if num == p3*c {
//			p3++
//		}
//		dp = num
//	}
//	return dp
//}
