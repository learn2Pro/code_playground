# 807. Max Increase to Keep City Skyline
from functools import reduce
from typing import List

'''
[[3,0,8,4],[2,4,5,7],[9,2,6,3],[0,3,1,0]]
[[1],[2]]
[[1,2]]
[[1,2,3,4],[4,3,2,1]]
'''
class _807_Solution:
    def maxIncreaseKeepingSkyline(self, grid: List[List[int]]) -> int:
        M, N = len(grid), len(grid[0])
        row = [max(lst) for lst in grid]
        col = [max(lst) for lst in zip(*grid)]
        ans = 0
        for i in range(M):
            for j in range(N):
                ans += min(col[j], row[i]) - grid[i][j]
        return ans


if __name__ == '__main__':
    tar = _807_Solution()
    assert tar.maxIncreaseKeepingSkyline([[1, 2]]) == 0
    assert tar.maxIncreaseKeepingSkyline([[3, 0, 8, 4], [2, 4, 5, 7], [9, 2, 6, 3], [0, 3, 1, 0]]) == 35
