# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxArea(self, height: List[int]) -> int:
        n = len(height)
        ans = 0
        l, r = 0, n - 1
        while l <= r:
            h = min(height[l], height[r])
            ans = max(ans, h * (r - l))
            if height[l] <= height[r]:
                l += 1
            else:
                r -= 1
        return ans
# leetcode submit region end(Prohibit modification and deletion)
