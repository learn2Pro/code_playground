# 221. Maximal Square
from typing import List


class _221_Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if not matrix or not matrix[0]: return 0
        m, n = len(matrix), len(matrix[0])
        dp = [[0] * n for _ in range(m)]
        ans = 0
        for i in range(m):
            if matrix[i][0] == '0': continue
            dp[i][0], ans = 1, 1
        for j in range(n):
            if matrix[0][j] == '0': continue
            dp[0][j], ans = 1, 1
        for i in range(1, m):
            for j in range(1, n):
                if matrix[i][j] == '0': continue
                dp[i][j] = min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]) + 1
                ans = max(ans, dp[i][j])
        return ans * ans


if __name__ == '__main__':
    instance = _221_Solution
    assert instance.maximalSquare(instance,
                                  [["1", "0", "1", "0", "0"], ["1", "0", "1", "1", "1"], ["1", "1", "1", "1", "1"],
                                   ["1", "0", "0", "1", "0"]]) == 4
