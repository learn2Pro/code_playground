from typing import List


class _11_Solution:
    def maxArea(self, height: List[int]) -> int:
        left, right = (0, len(height) - 1)
        ans = 0
        while left < right:
            h = min(height[left], height[right])
            ans = max(ans, h * (right - left))
            if height[left] > height[right]:
                right -= 1
            else:
                left += 1
        return ans
