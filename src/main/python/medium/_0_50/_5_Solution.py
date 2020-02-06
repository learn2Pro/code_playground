# 3. Longest Substring Without Repeating Characters
class _5_Solution:
    def longestPalindrome(self, s: str) -> str:
        C, R, radius, max_sz, idx = 0, -1, 0, 0, 0
        T = "#" + "#".join(s) + "#"
        N = len(T)
        P = [0] * N
        for i in range(1, N):
            if i <= R:
                radius = min(P[2 * C - i], R - i)
            else:
                radius = 0
            while i + radius < N and i - radius >= 0 and T[i + radius] == T[i - radius]:
                radius += 1
            P[i] = radius - 1
            if (P[i] > max_sz):
                max_sz, idx = P[i], i
            # exceed
            if i + radius - 1 > R:
                C, R = i, i + radius - 1
        return "".join(T[idx - max_sz:idx + max_sz + 1].split("#"))


# def longestPalindrome(self, s: str) -> str:
#     str_len = len(s)
#     # if length of string < 2 or s is palindrome already
#     if str_len < 2 or s == s[::-1]:
#         return s
#
#     start, max_len = 0, 1
#
#     for i in range(1, str_len):
#         odd_start = i - max_len - 1
#         even_start = i - max_len
#         odd = s[odd_start:i + 1]  # len(odd) = max_len + 2
#         even = s[even_start:i + 1]  # len(even) = max_len + 1
#
#         if odd_start >= 0 and odd == odd[::-1]:
#             start = odd_start
#             max_len += 2
#         elif even_start >= 0 and even == even[::-1]:
#             start = even_start
#             max_len += 1
#     return s[start:start + max_len]

# def longestPalindrome(self, s: str) -> str:
#     if len(s) == 0:
#         return s
#     sz = 0
#     ans = ""
#     dp = [[0] * len(s) for i in range(len(s))]
#     for i in range(len(s) - 1, -1, -1):
#         dp[i][i] = 1
#         if dp[i][i] > sz:
#             sz = dp[i][i]
#             ans = s[i:i + 1]
#         for j in range(i + 1, len(s)):
#             if s[i] == s[j] and dp[i + 1][j - 1] == j - i - 1:
#                 dp[i][j] = dp[i + 1][j - 1] + 2
#                 if dp[i][j] > sz:
#                     sz = dp[i][j]
#                     ans = s[i:j + 1]
#     return ans


if __name__ == '__main__':
    instance = _5_Solution()
    assert instance.longestPalindrome("babad") == "bab"
    assert instance.longestPalindrome("abcda") == "a"
    assert instance.longestPalindrome("abb") == "bb"
    assert instance.longestPalindrome("aaaaab") == "aaaaa"
    assert instance.longestPalindrome("aaaaaa") == "aaaaaa"
    assert instance.longestPalindrome("") == ""
    assert instance.longestPalindrome("a") == "a"
