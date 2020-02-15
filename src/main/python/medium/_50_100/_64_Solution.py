# 64. Minimum Path Sum
from typing import List

'''[[1,3,1],[1,5,1],[4,2,1]]
[[1,1,1]]
[[1],[1],[1]]
[]
[[1]]'''


class _64_Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        m = len(grid)
        if m == 0: return 0
        n = len(grid[0])
        if n == 0: return 0
        dp = [grid[0][0]]
        for j in range(1, n): dp.append(dp[-1] + grid[0][j])
        for i in range(1, m):
            dp.append(dp[0] + grid[i][0])
            dp.pop(0)
            for j in range(1, n):
                dp.append(min(dp[-1], dp[0]) + grid[i][j])
                dp.pop(0)
        return dp[-1]

    # def minPathSum(self, grid: List[List[int]]) -> int:
    #     m = len(grid)
    #     if m == 0: return 0
    #     n = len(grid[0])
    #     if n == 0: return 0
    #     dp = [[0] * n for i in range(m)]
    #     dp[0][0] = grid[0][0]
    #     for i in range(1, m): dp[i][0] = dp[i - 1][0] + grid[i][0]
    #     for j in range(1, n): dp[0][j] = dp[0][j - 1] + grid[0][j]
    #     for i in range(1, m):
    #         for j in range(1, n):
    #             dp[i][j] = min(dp[i - 1][j] , dp[i][j - 1]) + grid[i][j]
    #     return dp[-1][-1]


if __name__ == '__main__':
    instance = _64_Solution
    assert instance.minPathSum(instance, [[1, 2], [1, 1]]) == 3
