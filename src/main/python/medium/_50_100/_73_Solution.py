# 73. Set Matrix Zeroes
from typing import List


class _73_Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        m, n = len(matrix), len(matrix[0])
        isRowZero, isColZero = False, False
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == 0:
                    if j == 0: isRowZero = True
                    if i == 0: isColZero = True
                    matrix[i][0] = 0
                    matrix[0][j] = 0
        for j in range(1, n):
            if matrix[0][j] == 0:
                for i in range(1, m):
                    matrix[i][j] = 0
        for i in range(1, m):
            if matrix[i][0] == 0:
                for j in range(1, n):
                    matrix[i][j] = 0
        if isRowZero:
            for i in range(m):
                matrix[i][0] = 0
        if isColZero:
            for j in range(n):
                matrix[0][j] = 0


if __name__ == '__main__':
    instance = _73_Solution
    assert instance.setZeroes(instance, [[0, 1, 2, 0], [3, 4, 5, 2], [1, 3, 1, 5]]) == [[0, 0, 0, 0], [0, 4, 5, 0],
                                                                                        [0, 3, 1, 0]]
    assert instance.setZeroes(instance, [[1, 1, 1], [1, 0, 1], [1, 1, 1]]) == [[1, 0, 1], [0, 0, 0], [1, 0, 1]]
