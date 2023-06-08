from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        # zigzag search from (0,n-1)
        m, n = len(matrix), len(matrix[0])
        row, col = 0, n - 1
        while row < m and col >= 0:
            v = matrix[row][col]
            if v == target:
                return True
            elif v < target:
                row += 1
            else:
                col -= 1
        return False
# leetcode submit region end(Prohibit modification and deletion)
