# 279. Perfect Squares
from math import sqrt

'''
12
13
25
26
100
'''
class _279_Solution:
    # math
    def numSquares(self, n: int) -> int:

        def isSquare(n: int) -> bool:
            radix = int(sqrt(n))
            return radix * radix == n

        if n == 0: return 0
        if isSquare(n): return 1
        # 4^k*(8*a+7) four-square
        while n & 3 == 0:
            n >>= 2
        if n & 7 == 7: return 4
        for i in range(1, int(n ** 0.5) + 1):
            if isSquare(n - i * i): return 2
        return 3
    # bfs
    # def numSquares(self, n: int) -> int:
    #     if n == 0: return 0
    #     lst = [i * i for i in range(1, int(n ** 0.5) + 1)]
    #     set0 = {n}
    #     count = 0
    #     while set0:
    #         set1 = set()
    #         count += 1
    #         for num in set0:
    #             for i in lst:
    #                 if i > num: break
    #                 if i == num:
    #                     return count
    #                 else:
    #                     set1.add(num - i)
    #         set0 = set1
    #     return count

    # dp
    # def numSquares(self, n: int) -> int:
    #     dp = [0xffffffff] * (n + 1)
    #     dp[0] = 0
    #     for i in range(1, n + 1):
    #         for j in range(1, int(i ** 0.5) + 1):
    #             dp[i] = min(dp[i], dp[i - j * j] + 1)
    #     return dp[n]
    # dfs
    # def numSquares(self, n: int) -> int:
    #     minimal = n
    #
    #     def find(previous: int, remain: int) -> None:
    #         if remain == 0:
    #             nonlocal minimal
    #             minimal = min(minimal, previous)
    #             return
    #         sqrt = int(remain ** 0.5)
    #         for i in range(sqrt, 0, -1):
    #             find(previous + 1, remain - i * i)
    #
    #     find(0, n)
    #     return minimal


if __name__ == '__main__':
    instance = _279_Solution()
    assert instance.numSquares(1) == 1
    assert instance.numSquares(12) == 3
    assert instance.numSquares(13) == 2
