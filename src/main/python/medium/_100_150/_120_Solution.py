# 120. Triangle
from typing import List

'''
[]
[[1]]
[[1],[2,3]]
'''


class _120_Solution:
    # bottom-up
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        if not triangle or not triangle[0]: return 0
        n = len(triangle)
        for i in range(n - 2, -1, -1):
            for j in range(i + 1):
                tmp = triangle[i][j]
                triangle[i][j] = min(triangle[i + 1][j], triangle[i + 1][j + 1]) + tmp
        return triangle[0][0]


# top-down
# def minimumTotal(self, triangle: List[List[int]]) -> int:
#     if not triangle or not triangle[0]: return 0
#     n = len(triangle)
#     dp = [0] * n
#     dp[0] = triangle[0][0]
#     ans = dp[0] if n == 1 else 0x7fffffff
#     for level in range(1, n):
#         last = dp[0]
#         for i in range(level + 1):
#             if i == 0 or i == level:
#                 dp[i] = last + triangle[level][i]
#             else:
#                 mini = min(last, dp[i])
#                 last = dp[i]
#                 dp[i] = mini + triangle[level][i]
#             if level == n - 1: ans = min(ans, dp[i])
#     return ans


# def minimumTotal(self, triangle: List[List[int]]) -> int:
#     minimum = 0x7fffffff
#     height = len(triangle)
#
#     def dfs(level: int, index: int, sum: int) -> None:
#         if level >= height:
#             nonlocal minimum
#             minimum = min(minimum, sum)
#             return
#         sum += triangle[level][index]
#         dfs(level + 1, index, sum)
#         dfs(level + 1, index + 1, sum)
#         sum -= triangle[level][index]
#
#     dfs(0, 0, 0)
#     return minimum


if __name__ == '__main__':
    instance = _120_Solution
    assert instance.minimumTotal(instance, [[2], [3, 4], [6, 5, 7], [4, 1, 8, 3]]) == 11
    assert instance.minimumTotal(instance, []) == 0
    assert instance.minimumTotal(instance, [[1]]) == 1
