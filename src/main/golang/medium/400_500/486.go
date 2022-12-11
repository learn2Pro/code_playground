package medium

func PredictTheWinner(nums []int) bool {
	n := len(nums)
	dp := make([][][2]int, n)
	for i := 0; i < n; i++ {
		dp[i] = make([][2]int, n)
		dp[i][i] = [2]int{nums[i], 0}
	}
	//for span := 1; span < n; span++ {
	//	for i := 0; i < n-1; i++ {
	//		j := i + span
	//
	//		s0, s1 := dp[i+1][j][1]+nums[i], dp[i][j-1][1]+nums[j]
	//		var fst, snd int
	//		if s0 > s1 {
	//			fst, snd = s0, dp[i+1][j][0]
	//		} else {
	//			fst, snd = s1, dp[i][j-1][0]
	//		}
	//		dp[i][j] = [2]int{fst, snd}
	//	}
	//}
	for i := n - 2; i >= 0; i-- {
		for j := i + 1; j < n; j++ {
			s0, s1 := dp[i+1][j][1]+nums[i], dp[i][j-1][1]+nums[j]
			var fst, snd int
			if s0 > s1 {
				fst, snd = s0, dp[i+1][j][0]
			} else {
				fst, snd = s1, dp[i][j-1][0]
			}
			dp[i][j] = [2]int{fst, snd}
		}
	}
	return dp[0][n-1][0]-dp[0][n-1][1] > 0
}
