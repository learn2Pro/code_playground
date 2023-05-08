from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m, n = len(matrix), len(matrix[0])
        l, r = 0, m * n
        while l < r:
            mid = (l + r) >> 1
            if matrix[mid // n][mid % n] < target:
                l = mid + 1
            else:
                r = mid
        return l < m * n and matrix[l // n][l % n] == target


# leetcode submit region end(Prohibit modification and deletion)
if __name__ == '__main__':
    print("123")
