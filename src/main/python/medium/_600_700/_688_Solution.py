# 688. Knight Probability in Chessboard
from functools import lru_cache


class _688_Solution:
    # use dp
    def knightProbability(self, N: int, K: int, r: int, c: int) -> float:
        dp = [[[0.0] * N for _ in range(N)] for _ in range(K + 1)]
        dp[0][r][c] = 1.0
        direction = [[-1, -2], [-1, 2], [1, 2], [1, -2], [2, -1], [2, 1], [-2, -1], [-2, 1]]
        for time in range(1, K + 1):
            for i in range(N):
                for j in range(N):
                    for lst in direction:
                        x, y = i + lst[0], j + lst[1]
                        if x < 0 or x >= N or y < 0 or y >= N: continue
                        dp[time][x][y] += dp[time - 1][i][j] * 0.125
        return sum(sum(inner) for inner in dp[K])

    # use dfs
    def knightProbability(self, N: int, K: int, r: int, c: int) -> float:

        direction = [[-1, -2], [-1, 2], [1, 2], [1, -2], [2, -1], [2, 1], [-2, -1], [-2, 1]]

        @lru_cache(None)
        def dfs(x, y, k):
            if x < 0 or x >= N or y < 0 or y >= N:
                return 0
            elif k == 0:
                return 1
            return sum(map(lambda lst: dfs(x + lst[0], y + lst[1], k - 1), direction)) / 8.0

        return dfs(r, c, K)


'''
3
2
0
0
5
5
0
0
5
5
1
1
1
0
0
0
2
0
1
0
'''
if __name__ == '__main__':
    obj = _688_Solution()
    assert obj.knightProbability(5, 5, 1, 1) == 0.03906
    assert obj.knightProbability(3, 2, 0, 0) == 0.0625
