# 54. Spiral Matrix
from typing import List

'''
[[1,2,3],[4,5,6],[7,8,9]]
[]
[[1]]
[[1,2,3]]
[[1],[2],[3]]
'''


class _54_Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        m = len(matrix)
        if m == 0: return []
        n = len(matrix[0])
        ans = []
        s_row, e_row, s_col, e_col = 0, m - 1, 0, n - 1
        while s_row <= e_row and s_col <= e_col:
            for y in range(s_col, e_col + 1):
                ans.append(matrix[s_row][y])
            s_row += 1
            for x in range(s_row, e_row + 1):
                ans.append(matrix[x][e_col])
            e_col -= 1
            if s_row <= e_row:
                for y in range(e_col, s_col - 1, -1):
                    ans.append(matrix[e_row][y])
            e_row -= 1
            if s_col <= e_col:
                for x in range(e_row, s_row - 1, -1):
                    ans.append(matrix[x][s_col])
            s_col += 1
        return ans
    # def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
    #     m = len(matrix)
    #     if m == 0: return []
    #     n = len(matrix[0])
    #     ans = []
    #     row, col = m, n
    #     while row > 0 and col > 0:
    #         top, left = (m - row) // 2, (n - col) // 2
    #         down, right = m - 1 - (m - row) // 2, n - 1 - (n - col) // 2
    #         ans.append(matrix[top][left])
    #         for y in range(left + 1, right):
    #             ans.append(matrix[top][y])
    #         for x in range(top, down):
    #             if left == right and x == top: ans.pop()
    #             ans.append(matrix[x][right])
    #         for y in range(right, left, -1):
    #             if top == down: ans.append(matrix[down][right]);break;
    #             ans.append(matrix[down][y])
    #         for x in range(down, top, -1):
    #             if left == right: ans.append(matrix[down][left]);break;
    #             ans.append(matrix[x][left])
    #         row -= 2
    #         col -= 2
    #     return ans


if __name__ == '__main__':
    instance = _54_Solution
    assert instance.spiralOrder(instance, [
        [1, 2, 3],
        [4, 5, 6],
        [7, 8, 9]
    ]) == [1, 2, 3, 6, 9, 8, 7, 4, 5]
    assert instance.spiralOrder(instance, [
        [1, 2, 3]
    ]) == [1, 2, 3]
    assert instance.spiralOrder(instance, [
        [1], [2], [3]
    ]) == [1, 2, 3]
    assert instance.spiralOrder(instance, [
        [1]
    ]) == [1]
    assert instance.spiralOrder(instance, [
        [1, 2],
        [2, 1]
    ]) == [1, 2, 1, 2]
    assert instance.spiralOrder(instance, [
        [1, 2, 3, 4],
        [5, 6, 7, 8],
        [9, 10, 11, 12]
    ]) == [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
