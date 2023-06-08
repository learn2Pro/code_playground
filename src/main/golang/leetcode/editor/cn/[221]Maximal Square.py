from typing import List
# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if not matrix:
            return 0
        n, m = len(matrix), len(matrix[0])
        dp = [[0] * m for _ in range(n)]
        ans = 0
        for i in range(n):
            for j in range(m):
                if matrix[i][j] == '1':
                    dp[i][j] = 1
                    if i > 0 and j > 0:
                        dp[i][j] += min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1])
                    ans = max(ans, dp[i][j])
        return ans * ans
# leetcode submit region end(Prohibit modification and deletion)
