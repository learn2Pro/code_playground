# 375. Guess Number Higher or Lower II
from collections import deque


class _375_Solution:
    # def getMoneyAmount(self, n: int) -> int:
    #     if n == 0: return 0
    #     dp = [[0] * (n + 1) for _ in range(n + 1)]
    #     times = [[0] * (n + 1) for _ in range(n + 1)]
    #     for i in range(n - 1, -1, -1):
    #         dp[i][i] = 0
    #         times[i][i] = 0
    #         if i != n - 1: dp[i][n - 1] = 0x7fffffff
    #         for j in range(i + 1, n):
    #             if j + 1 + max(dp[n - j + i][n - 1] - (n - j) * times[n - j + i][n - 1],
    #                            dp[j + 1][n - 1]) < dp[i][n - 1]:
    #                 if dp[n - j + i][n - 1] - (n - j) * times[n - j + i][n - 1] > dp[j + 1][n - 1]:
    #                     times[i][n - 1] = times[n - j + i][n - 1] + 1
    #                 else:
    #                     times[i][n - 1] = times[j + 1][n - 1] + 1
    #                 dp[i][n - 1] = j + 1 + max(dp[n - j + i][n - 1] - (n - j) * times[n - j + i][n - 1],
    #                                            dp[j + 1][n - 1])
    #     return dp[0][n - 1]
    # dp[n] = n-1+dp[n-2]
    # o(n^3)
    # use deque
    def getMoneyAmount(self, n: int) -> int:
        dp = [[0] * (n + 1) for _ in range(n + 1)]
        for j in range(2, n + 1):
            gkb, k0 = deque(), j - 1
            for i in range(j - 1, 0, -1):
                while dp[i][k0 - 1] > dp[k0 + 1][j]:
                    k0 -= 1
                while gkb and gkb[0][1] > k0:
                    gkb.popleft()
                sum = dp[i + 1][j] + i
                while gkb and gkb[-1][0] >= sum:
                    gkb.pop()
                gkb.append((sum, i))
                dp[i][j] = min(gkb[0][0], dp[i][k0] + k0 + 1)
        return dp[1][n]
    # def getMoneyAmount(self, n: int) -> int:
    #     if n == 0: return 0
    #     dp = [[0] * (n + 1) for _ in range(n + 1)]
    #     for i in range(n - 1, -1, -1):
    #         dp[i][i] = 0
    #         for j in range(i + 1, n):
    #             dp[i][j] = 0x7fffffff
    #             for k in range(i, j + 1):
    #                 dp[i][j] = min(dp[i][j], k + 1 + max(dp[i][k - 1], dp[k + 1][j]))
    #     return dp[0][n - 1]


if __name__ == '__main__':
    obj = _375_Solution()
    assert obj.getMoneyAmount(1) == 0
    assert obj.getMoneyAmount(6) == 8
    assert obj.getMoneyAmount(10) == 16
