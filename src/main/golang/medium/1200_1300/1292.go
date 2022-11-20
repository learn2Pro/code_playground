package medium

func maxSideLength(mat [][]int, threshold int) int {
	Min := func(x, y int) int {
		if x < y {
			return x
		}
		return y
	}
	m, n := len(mat), len(mat[0])
	dp := make([][]int, m+1)
	for i := 0; i < m+1; i++ {
		dp[i] = make([]int, n+1)
	}
	for i := 1; i <= m; i++ {
		for j := 1; j <= n; j++ {
			dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + mat[i-1][j-1]
		}
	}
	GetSum := func(x, y, i, j int) int {
		return dp[x][y] - dp[i-1][y] - dp[x][j-1] + dp[i-1][j-1]
	}
	var ans int
	l, r := 1, Min(m, n)
	for l <= r {
		mid := l + (r-l)/2
		var find bool
		for i := 1; i <= m-mid+1; i++ {
			for j := 1; j <= n-mid+1; j++ {
				if GetSum(i+mid-1, j+mid-1, i, j) <= threshold {
					find = true
				}
			}
		}
		if find {
			ans = mid
			l = mid + 1
		} else {
			r = mid - 1
		}
	}
	return ans
}

func maxSideLength1(mat [][]int, threshold int) int {
	Min := func(x, y int) int {
		if x < y {
			return x
		}
		return y
	}
	m, n := len(mat), len(mat[0])
	dp := make([][]int, m+1)
	for i := 0; i < m+1; i++ {
		dp[i] = make([]int, n+1)
	}
	for i := 1; i <= m; i++ {
		for j := 1; j <= n; j++ {
			dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + mat[i-1][j-1]
		}
	}
	GetSum := func(x, y, i, j int) int {
		return dp[x][y] - dp[i-1][y] - dp[x][j-1] + dp[i-1][j-1]
	}
	var ans int
	r := Min(m, n)
	for i := 1; i <= m; i++ {
		for j := 1; j <= n; j++ {
			for s := ans; s < r; s++ {
				x, y := i+s, j+s
				if x <= m && y <= n && GetSum(x, y, i, j) <= threshold {
					ans += 1
				} else {
					break
				}
			}
		}
	}
	return ans
}
