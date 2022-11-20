package medium

func smallestDivisor(nums []int, threshold int) int {
	Max := func(x, y int) int {
		if x > y {
			return x
		}
		return y
	}
	Divide := func(x, y int) int {
		if x%y == 0 {
			return x / y
		}
		return x/y + 1
	}
	var max int
	for _, num := range nums {
		max = Max(max, num)
	}
	l, r := 1, max+1
	for l < r {
		mid := l + (r-l)/2
		var sum int
		for _, num := range nums {
			sum += Divide(num, mid)
		}
		if sum > threshold {
			l = mid + 1
		} else {
			r = mid
		}
	}
	return l
}
