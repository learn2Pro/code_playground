from typing import List

'''
["NumMatrix","sumRegion","sumRegion","sumRegion"]
[[[[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]],[2,1,4,3],[1,1,2,2],[1,2,2,4]]
["NumMatrix","sumRegion","sumRegion","sumRegion","sumRegion","sumRegion","sumRegion","sumRegion"]
[[[[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]],[2,1,4,3],[1,1,2,2],[1,2,2,4],[0,0,3,3],[1,0,3,3],[0,1,3,3],[1,1,1,1]]
["NumMatrix"]
[[[]]]
'''


class NumMatrix:

    def __init__(self, matrix: List[List[int]]):
        if not matrix or not matrix[0]: return
        m, n = len(matrix), len(matrix[0])
        for i in range(1, m):
            matrix[i][0] += matrix[i - 1][0]
        for j in range(1, n):
            matrix[0][j] += matrix[0][j - 1]
        for i in range(1, m):
            for j in range(1, n):
                matrix[i][j] += matrix[i - 1][j] + matrix[i][j - 1] - matrix[i - 1][j - 1]
        self.grid = matrix
        self.m = m
        self.n = n

    def fetch(self, i: int, j: int):
        if i < 0 or i >= self.m or j < 0 or j >= self.n: return 0
        return self.grid[i][j]

    def sumRegion(self, row1: int, col1: int, row2: int, col2: int) -> int:
        if not self.grid: return 0
        return self.fetch(row2, col2) - self.fetch(row1 - 1, col2) - self.fetch(row2, col1 - 1) + self.fetch(row1 - 1,
                                                                                                             col1 - 1)
