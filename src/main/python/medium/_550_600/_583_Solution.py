# 583. Delete Operation for Two Strings
'''
"sea"
"eat"
""
""
""
"a"
"abcs"
"abcd"
"dcba"
"abcd"
"asda"
""
"asdalkdjqowieuqoeiqocncnwryiwrwsdiqoweoqnladladqowieqoqodjqdoiqwq"
"saqweoqxa"
'''
from functools import lru_cache


class _583_Solution:
    # 2d-array
    def minDistance(self, word1: str, word2: str) -> int:
        n0, n1 = len(word1), len(word2)
        if n0 * n1 == 0:
            return max(n0, n1)
        dp = [[0x7fffffff] * (n1 + 1) for _ in range(n0 + 1)]
        dp[0][0] = 0
        for i in range(n0 + 1):
            for j in range(n1 + 1):
                if i == 0 or j == 0:
                    dp[i][j] = i + j
                elif word1[i - 1] == word2[j - 1]:
                    dp[i][j] = dp[i - 1][j - 1]
                else:
                    dp[i][j] = min(dp[i - 1][j], dp[i][j - 1]) + 1
        return dp[n0][n1]

    # 1d-array
    def minDistance(self, word1: str, word2: str) -> int:
        n0, n1 = len(word1), len(word2)
        dp = [0] * (n1 + 1)

        for i in range(n0 + 1):
            current = [0] * (n1 + 1)
            for j in range(n1 + 1):
                if i == 0 or j == 0:
                    current[j] = i+j
                elif word1[i - 1] == word2[j - 1]:
                    current[j] = dp[j-1]
                else:
                    current[j] = min(dp[j], current[j - 1]) + 1
            dp = current
        return dp[-1]

    # use lcs
    def minDistance(self, word1: str, word2: str) -> int:
        m, n = len(word1), len(word2)

        @lru_cache(maxsize=1024)
        def lcs(l0: int, l1: int) -> int:
            if l0 == 0 or l1 == 0:
                return 0
            if word1[l0 - 1] == word2[l1 - 1]:
                return 1 + lcs(l0 - 1, l1 - 1)
            else:
                return max(lcs(l0 - 1, l1), lcs(l0, l1 - 1))

        return m + n - 2 * lcs(m, n)


if __name__ == '__main__':
    obj = _583_Solution()
    assert obj.minDistance("", "") == 1
    assert obj.minDistance("abcd", "asda") == 4
