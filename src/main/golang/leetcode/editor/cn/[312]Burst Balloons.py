from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        points = [1] + nums + [1]
        dp = [[0] * len(points) for _ in range(len(points))]
        n = len(points)
        for i in range(n - 2, -1, -1):
            for j in range(i + 2, n):
                for k in range(i + 1, j):
                    dp[i][j] = max(dp[i][j], dp[i][k] + dp[k][j] + points[i] * points[k] * points[j])
        return dp[0][n - 1]
# leetcode submit region end(Prohibit modification and deletion)
