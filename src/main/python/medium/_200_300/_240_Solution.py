# 240. Search a 2D Matrix II
class _240_Solution:
    # o(m*log(n))
    def searchMatrix(self, matrix, target):
        if not matrix or not matrix[0]: return False
        m, n = len(matrix), len(matrix[0])
        for row in range(m):
            if matrix[row][n - 1] < target: continue
            lo, hi = 0, n - 1
            while lo <= hi:
                mid = (lo + hi) >> 1
                if matrix[row][mid] == target:
                    return True
                elif matrix[row][mid] < target:
                    lo = mid + 1
                else:
                    hi = mid - 1
        return False
    # o(m+n)
    # def searchMatrix(self, matrix, target):
    #     """
    #     :type matrix: List[List[int]]
    #     :type target: int
    #     :rtype: bool
    #     """
    #     if not matrix or not matrix[0]: return False
    #     m, n = len(matrix), len(matrix[0])
    #     pointerX, pointerY = 0, n - 1
    #     while pointerX >= 0 and pointerX < m and pointerY >= 0 and pointerY < n:
    #         if target == matrix[pointerX][pointerY]:
    #             return True
    #         elif target < matrix[pointerX][pointerY]:
    #             pointerY -= 1
    #         else:
    #             pointerX += 1
    #     return False
