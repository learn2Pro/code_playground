# 48. Rotate Image
from typing import List


class _48_Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        n = len(matrix)
        for size in range(n, 1, -2):
            for x in range(size - 1):
                left, topper = (n - size) // 2, (n - size) // 2
                right, downer = n - 1 - left, n - 1 - topper
                tmp = matrix[topper][left + x]
                matrix[topper][left + x] = matrix[downer - x][left]
                matrix[downer - x][left] = matrix[downer][right - x]
                matrix[downer][right - x] = matrix[topper + x][right]
                matrix[topper + x][right] = tmp


if __name__ == '__main__':
    instance = _48_Solution
    input = [
        [1]
    ]
    instance.rotate(instance, input)
    assert input == [
        [1]
    ]
    input = [
        [1, 2],
        [2, 1]
    ]
    instance.rotate(instance, input)
    assert input == [
        [2, 1],
        [1, 2]
    ]
    input = [
        [1, 2, 3],
        [4, 5, 6],
        [7, 8, 9]
    ]
    instance.rotate(instance, input)
    assert input == [
        [7, 4, 1],
        [8, 5, 2],
        [9, 6, 3]
    ]
    input = [
        [5, 1, 9, 11],
        [2, 4, 8, 10],
        [13, 3, 6, 7],
        [15, 14, 12, 16]
    ]
    instance.rotate(instance, input)
    assert input == [
        [15, 13, 2, 5],
        [14, 3, 4, 1],
        [12, 6, 8, 9],
        [16, 7, 10, 11]
    ]
