# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def numSquares(self, n: int) -> int:
        square = [i * i for i in range(1, int(n ** 0.5) + 1)]
        dp = [0] * (n + 1)
        for i in range(1, n + 1):
            dp[i] = min([dp[i - j] for j in square if j <= i]) + 1
        return dp[n]
# leetcode submit region end(Prohibit modification and deletion)
