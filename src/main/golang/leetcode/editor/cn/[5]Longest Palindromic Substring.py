# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def longestPalindrome(self, s: str) -> str:
        n = len(s)

        def isPalindrome(l: int, r: int) -> str:
            while l >= 0 and r < n and s[l] == s[r]:
                l, r = l - 1, r + 1
            return s[l + 1:r]

        res = ""
        for i in range(n):
            s0, s1 = isPalindrome(i, i), isPalindrome(i, i + 1)
            res = s0 if len(s0) > len(res) else res
            res = s1 if len(s1) > len(res) else res
        return res

# leetcode submit region end(Prohibit modification and deletion)
