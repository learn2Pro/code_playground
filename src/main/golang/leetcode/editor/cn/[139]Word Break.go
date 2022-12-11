package lc

//leetcode submit region begin(Prohibit modification and deletion)
func wordBreak(s string, wordDict []string) bool {
	dictset := make(map[string]bool)
	for _, word := range wordDict {
		dictset[word] = true
	}
	n := len(s)
	dp := make([]bool, n+1)
	dp[0] = true
	for i := 1; i <= n; i++ {
		for j := 0; j < i; j++ {
			if dp[j] && dictset[s[j:i]] {
				dp[i] = true
				break
			}
		}
	}
	return dp[n]
}

//leetcode submit region end(Prohibit modification and deletion)
