package medium

func nthSuperUglyNumber(n int, primes []int) int {
	min := func(x, y int) int {
		if x < y {
			return x
		} else {
			return y
		}
	}
	dp := make([]int, n+1)
	dp[1] = 1
	indexes := make([]int, len(primes))
	for i := 0; i < len(indexes); i++ {
		indexes[i] = 1
	}
	for i := 2; i <= n; i++ {
		var num = dp[indexes[0]] * primes[0]
		for j := 1; j < len(primes); j++ {
			num = min(num, dp[indexes[j]]*primes[j])
		}
		for k := 0; k < len(primes); k++ {
			if num == dp[indexes[k]]*primes[k] {
				indexes[k]++
			}
		}
		dp[i] = num
	}
	return dp[n]
}
