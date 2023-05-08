# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        ans = 0
        c_map = {}
        l, r = 0, 0
        while r < len(s):
            if s[r] in c_map:
                c_map[s[r]] += 1
            else:
                c_map[s[r]] = 1
            while l <= r and c_map[s[r]] > 1:
                c_map[s[l]] -= 1
                l += 1
            ans = max(ans, r - l + 1)
            r += 1
        return ans
# leetcode submit region end(Prohibit modification and deletion)
