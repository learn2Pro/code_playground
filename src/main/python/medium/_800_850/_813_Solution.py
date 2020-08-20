# 813. Largest Sum of Averages
from functools import lru_cache
from typing import List

'''
[9,1,2,3,9]
3
[9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3]
10
[9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3]
5
[9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3]
20
[9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3]
30
[9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3,9,9,1,2,3]
40
'''


class _813_Solution:
    def largestSumOfAverages(self, A: List[int], K: int) -> float:
        N = len(A)

        @lru_cache(None)
        def dfs(index, remain, acc, size):
            if index >= N:
                return 0 if size == 0 else acc / size
            ans = 0
            if remain > 0:
                ans = max(ans, (acc + A[index]) / (size + 1) + dfs(index + 1, remain - 1, 0, 0))
            ans = max(ans, dfs(index + 1, remain, acc + A[index], size + 1))
            return ans

        return dfs(0, K - 1, 0, 0)

    # use dp
    def largestSumOfAverages(self, A: List[int], K: int) -> float:
        N = len(A)
        summary = [0] * (N + 1)
        for i, item in enumerate(A):
            summary[i + 1] = summary[i] + item
        dp = [[(summary[N] - summary[i]) / (N - i) for i in range(N)] for _ in range(K)]
        for remain in range(1, K):
            for i in range(N):
                for j in range(i + 1, N):
                    dp[remain][i] = max(dp[remain][i], (summary[j] - summary[i]) / (j - i) + dp[remain - 1][j])
        return dp[-1][0]

    def largestSumOfAverages(self, A, K):
        P = [0]
        for x in A: P.append(P[-1] + x)

        def average(i, j):
            return (P[j] - P[i]) / float(j - i)

        N = len(A)
        dp = [average(i, N) for i in range(N)]
        for k in range(K - 1):
            for i in range(N):
                for j in range(i + 1, N):
                    dp[i] = max(dp[i], average(i, j) + dp[j])

        return dp[0]

    def largestSumOfAverages(self, A: List[int], K: int) -> float:
        N = len(A)
        summary = [0] * (N + 1)
        for i, item in enumerate(A):
            summary[i + 1] = summary[i] + item

        @lru_cache(None)
        def dfs(index, remain):
            if remain <= 0:
                return (summary[N] - summary[index]) / (N - index)
            if index >= N:
                return 0
            ans = 0
            for i in range(index + 1, N):
                ans = max(ans, (summary[i] - summary[index]) / (i - index) + dfs(i, remain - 1))
            return ans

        res = dfs(0, K - 1)
        return res


if __name__ == '__main__':
    tar = _813_Solution()
    assert tar.largestSumOfAverages([9, 1, 2, 3, 9], 3) == 20
