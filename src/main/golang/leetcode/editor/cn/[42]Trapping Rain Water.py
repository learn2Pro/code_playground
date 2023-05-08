from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def trap(self, height: List[int]) -> int:
        stack = []
        ans = 0
        for i, h in enumerate(height):
            while stack and h > height[stack[-1]]:
                top = stack.pop()
                if not stack:
                    break
                ans += (min(h, height[stack[-1]]) - height[top]) * (i - stack[-1] - 1)
            stack.append(i)
        return ans
# leetcode submit region end(Prohibit modification and deletion)
