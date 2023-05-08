from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    # Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
    def generateMatrix(self, n: int) -> List[List[int]]:
        l, r, u, d = 0, n - 1, 0, n - 1
        ans = [[0] * n for _ in range(n)]
        num = 1
        while num <= n * n:
            for y in range(l, r + 1):
                ans[u][y] = num
                num += 1
            u += 1
            for x in range(u, d + 1):
                ans[x][r] = num
                num += 1
            r -= 1
            for y in reversed(range(l, r + 1)):
                ans[d][y] = num
                num += 1
            d -= 1
            for x in reversed(range(u, d + 1)):
                ans[x][l] = num
                num += 1
            l += 1
        return ans

# leetcode submit region end(Prohibit modification and deletion)
