package lc

//leetcode submit region begin(Prohibit modification and deletion)
func maxCoins(nums []int) (ans int) {
	Max := func(x, y int) int {
		if x > y {
			return x
		}
		return y
	}
	n := len(nums)
	var points = make([]int, n+2)
	for i := 0; i < n; i++ {
		points[i+1] = nums[i]
	}
	points[0], points[n+1] = 1, 1
	dp := make([][]int, n+2)
	for i := 0; i < n+2; i++ {
		dp[i] = make([]int, n+2)
	}
	for i := n; i >= 0; i-- {
		for j := i + 1; j <= n+1; j++ {
			for k := i + 1; k < j; k++ {
				dp[i][j] = Max(dp[i][j], dp[i][k]+dp[k][j]+
					points[k]*points[i]*points[j])
			}
		}
	}
	return dp[0][n+1]
	//var burst func(arr []int, sum int)
	//burst = func(arr []int, sum int) {
	//	if len(arr) == 0 {
	//		ans = Max(ans, sum)
	//		return
	//	}
	//	for i, num := range arr {
	//		var s int
	//		if len(arr) == 1 {
	//			s = num
	//		} else if i == 0 {
	//			s = num * arr[i+1]
	//		} else if i == len(arr)-1 {
	//			s = num * arr[i-1]
	//		} else {
	//			s = arr[i-1] * num * arr[i+1]
	//		}
	//		var x []int
	//		x = append(x, arr[:i]...)
	//		x = append(x, arr[i+1:]...)
	//		burst(x, sum+s)
	//	}
	//}
	//burst(nums, 0)
	//return
}

//leetcode submit region end(Prohibit modification and deletion)
