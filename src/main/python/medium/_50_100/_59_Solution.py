# 59. Spiral Matrix II
from typing import List


class _59_Solution:
    def generateMatrix(self, n: int) -> List[List[int]]:
        ans = [[0] * n for i in range(n)]
        s_row, e_row, s_col, e_col = 0, n - 1, 0, n - 1
        num = 1
        while s_row <= e_row and s_col <= e_col:
            for y in range(s_col, e_col + 1):
                ans[s_row][y] = num
                num += 1
            s_row += 1
            for x in range(s_row, e_row + 1):
                ans[x][e_col] = num
                num += 1
            e_col -= 1
            if s_row <= e_row:
                for y in range(e_col, s_col - 1, -1):
                    ans[e_row][y] = num
                    num += 1
            e_row -= 1
            if s_col <= e_col:
                for x in range(e_row, s_row - 1, -1):
                    ans[x][s_col] = num
                    num += 1
            s_col += 1
        return ans
