# 3. Longest Substring Without Repeating Characters
class _5_Solution:
    def longestPalindrome(self, s: str) -> str:
        if len(s) == 0:
            return s
        sz = 0
        ans = ""
        dp = [[0] * len(s) for i in range(len(s))]
        for i in range(len(s) - 1, -1, -1):
            dp[i][i] = 1
            if dp[i][i] > sz:
                sz = dp[i][i]
                ans = s[i:i + 1]
            for j in range(i + 1, len(s)):
                if s[i] == s[j] and dp[i + 1][j - 1] == j - i - 1:
                    dp[i][j] = dp[i + 1][j - 1] + 2
                    if dp[i][j] > sz:
                        sz = dp[i][j]
                        ans = s[i:j + 1]
        return ans


if __name__ == '__main__':
    instance = _5_Solution()
    assert instance.longestPalindrome("abcda") == "a"
    assert instance.longestPalindrome("babad") == "aba"
    assert instance.longestPalindrome("") == ""
    assert instance.longestPalindrome("a") == "a"
    assert instance.longestPalindrome("aaaaaa") == "aaaaaa"
    assert instance.longestPalindrome("aaaaab") == "aaaaa"
