from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        ans = 0
        stack = []
        heights.append(0)
        for i, h in enumerate(heights):
            while stack and heights[stack[-1]] > h:
                top = stack.pop()
                if stack:
                    ans = max(ans, (i - stack[-1] - 1) * heights[top])
                else:
                    ans = max(ans, i * heights[top])
            stack.append(i)
        return ans
# leetcode submit region end(Prohibit modification and deletion)
