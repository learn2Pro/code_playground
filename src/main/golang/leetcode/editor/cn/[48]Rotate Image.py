from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        # n = len(matrix)
        # matrix0 = [[0] * n for _ in range(n)]
        # for i in range(n):
        #     for j in range(n):
        #         matrix0[j][n - 1 - i] = matrix[i][j]
        # matrix[:] = matrix0
        n = len(matrix)
        for i in range(n // 2):
            for j in range((n + 1) // 2):
                matrix[j][n - 1 - i], \
                matrix[n - 1 - i][n - 1 - j], \
                matrix[n - 1 - j][i], \
                matrix[i][j] = matrix[i][j], matrix[j][n - 1 - i], \
                               matrix[n - 1 - i][n - 1 - j], \
                               matrix[n - 1 - j][i]

# leetcode submit region end(Prohibit modification and deletion)
