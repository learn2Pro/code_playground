from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
# class Solution:
#     def setZeroes(self, matrix: List[List[int]]) -> None:
#         """
#         Do not return anything, modify matrix in-place instead.
#         """
#         dummy = 0x1ffffffff
#         m, n = len(matrix), len(matrix[0])
#         for i in range(m):
#             for j in range(n):
#                 if matrix[i][j] == 0:
#                     for k in range(m):
#                         matrix[k][j] = dummy if matrix[k][j] != 0 else 0
#                     for k in range(n):
#                         matrix[i][k] = dummy if matrix[i][k] != 0 else 0
#         for i in range(m):
#             for j in range(n):
#                 if matrix[i][j] == dummy:
#                     matrix[i][j] = 0
class Solution:
    def setZeroes(self, matrix):
        """
        Do not return anything, modify matrix in-place instead.
        """
        ml = range(len(matrix))
        nl = range(len(matrix[0]))
        res = []
        for i in ml:
            for j in nl:
                if matrix[i][j] == 0:
                    res.append(j)
        for i in ml:
            for j in nl:
                if matrix[i][j] == 0:
                    for k in nl:
                        matrix[i][k] = 0
                    break
        for r in res:
            for t in ml:
                matrix[t][r] = 0

# leetcode submit region end(Prohibit modification and deletion)
