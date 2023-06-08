
# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def shortestPalindrome(self, s: str) -> str:
        n = len(s)
        if n == 0:
            return s
        rev = s[::-1]
        for i in range(n):
            if s[:n - i] == rev[i:]:
                return rev[:i] + s
        return ""
# leetcode submit region end(Prohibit modification and deletion)
