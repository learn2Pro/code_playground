# 63. Unique Paths II
from typing import List


class _63_Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        m = len(obstacleGrid)
        if m == 0: return 0
        n = len(obstacleGrid[0])
        if n == 0: return 0
        dp = [[0] * n for i in range(m)]
        if obstacleGrid[0][0] == 0: dp[0][0] = 1
        for i in range(1, m):
            if obstacleGrid[i][0] == 0: dp[i][0] = dp[i - 1][0]
        for j in range(1, n):
            if obstacleGrid[0][j] == 0: dp[0][j] = dp[0][j - 1]
        for i in range(1, m):
            for j in range(1, n):
                if obstacleGrid[i][j] == 0:
                    dp[i][j] += (dp[i - 1][j] + dp[i][j - 1])
        return dp[m - 1][n - 1]


if __name__ == '__main__':
    instance = _63_Solution
    assert instance.uniquePathsWithObstacles(instance, [[0, 0, 0], [0, 1, 0], [0, 0, 0]]) == 2
