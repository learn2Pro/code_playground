package medium

func numTrees(n int) int {
	var memo = make([]int, 20)
	memo[0], memo[1] = 1, 1
	var counter func(x int) int
	counter = func(x int) int {
		if memo[x] > 0 {
			return memo[x]
		}
		var cnt int
		for i := 1; i <= x; i++ {
			cnt += counter(i-1) * counter(x-i)
		}
		memo[x] = cnt
		return cnt
	}
	return counter(n)
}
