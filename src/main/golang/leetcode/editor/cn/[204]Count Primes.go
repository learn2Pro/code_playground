package lc

//leetcode submit region begin(Prohibit modification and deletion)
func countPrimes(n int) (ans int) {
	var notPrime = make([]bool, n)
	isPrime := func(x int) bool {
		for i := 2; i*i < x; i++ {
			if x%i == 0 {
				return false
			}
		}
		return true
	}
	for i := 2; i*i < n; i++ {
		if isPrime(i) {
			for j := i * i; j < n; j += i {
				notPrime[j] = true
			}
		}
	}
	for i := 2; i < n; i++ {
		if !notPrime[i] {
			ans += 1
		}
	}
	return
}

//leetcode submit region end(Prohibit modification and deletion)
