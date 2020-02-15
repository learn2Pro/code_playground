# 74. Search a 2D Matrix
from typing import List

'''
[[1,3,5,7],[10,11,16,20],[23,30,34,50]]
3
[[1,3,5,7],[10,11,16,20],[23,30,34,50]]
12
[[1,3,5,7],[10,11,16,20],[23,30,34,50]]
11
[[1]]
1
[[1]]
2
[]'''


class _74_Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)
        if m == 0: return False
        n = len(matrix[0])
        if n == 0: return False
        i, j = m - 1, 0
        while i >= 0 and j < n:
            if matrix[i][j] == target:
                return True
            elif matrix[i][j] < target:
                j += 1
            else:
                i -= 1
        return False

    # def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
    #     m = len(matrix)
    #     if m == 0: return False
    #     n = len(matrix[0])
    #     if n == 0: return False
    #     lo, hi = 0, m * n - 1
    #     while lo <= hi:
    #         mid = (lo + hi) >> 1
    #         r, c = divmod(mid, n)
    #         if matrix[r][c] == target:
    #             return True
    #         elif matrix[r][c] < target:
    #             lo = mid + 1
    #         else:
    #             hi = mid - 1
    #     return False


if __name__ == '__main__':
    instance = _74_Solution
    assert instance.searchMatrix(instance, [[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 50]], 3)
    assert instance.searchMatrix(instance, [[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 50]], 11)
    assert not instance.searchMatrix(instance, [[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 50]], 12)
