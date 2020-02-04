# 516. Longest Palindromic Subsequence
# "bbbab"
# "cbbd"
# "aaaaa"
# "aaaaab"
# ""
class _516_Solution:
    def longestPalindromeSubseq(self, s: str) -> int:
        N = len(s)
        if N == 0: return 0
        dp = [[0] * N for i in range(N)]
        for i in range(N - 1, -1, -1):
            dp[i][i] = 1
            for j in range(i + 1, N):
                if s[i] == s[j]:
                    dp[i][j] = dp[i + 1][j - 1] + 2
                else:
                    dp[i][j] = max(dp[i + 1][j], dp[i][j - 1])

        return dp[0][N - 1]


if __name__ == '__main__':
    instance = _516_Solution
    assert instance.longestPalindromeSubseq(instance, "") == 0
    assert instance.longestPalindromeSubseq(instance, "cbbd") == 2
    assert instance.longestPalindromeSubseq(instance, "bbbab") == 4
