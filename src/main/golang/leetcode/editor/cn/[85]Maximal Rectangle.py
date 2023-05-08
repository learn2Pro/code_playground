from typing import List

# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maximalRectangle(self, matrix: List[List[str]]) -> int:
        if not matrix:
            return 0
        ans = 0
        m, n = len(matrix), len(matrix[0])
        heights = [0] * (n + 1)
        for i in range(m):
            stack = []
            for j in range(n + 1):
                if j < n:
                    heights[j] = heights[j] + 1 if matrix[i][j] == '1' else 0
                while stack and heights[stack[-1]] > heights[j]:
                    top = stack.pop()
                    if stack:
                        ans = max(ans, (j - stack[-1] - 1) * heights[top])
                    else:
                        ans = max(ans, j * heights[top])
                stack.append(j)
        return ans
# leetcode submit region end(Prohibit modification and deletion)
