# 678. Valid Parenthesis String
from typing import List
from functools import lru_cache


class _678_Solution:
    # dfs
    def checkValidString(self, s: str) -> bool:
        if not s: return True

        @lru_cache(None)
        def dfs(index, current):
            if index >= len(s):
                return current == 0
            if s[index] == '(':
                current += 1
                if dfs(index + 1, current): return True
                current -= 1
            elif s[index] == ')':
                if current <= 0: return False
                current -= 1
                if dfs(index + 1, current): return True
                current += 1
            else:
                if dfs(index + 1, current): return True
                current += 1
                if dfs(index + 1, current): return True
                current -= 1
                if current <= 0: return False
                current -= 1
                if dfs(index + 1, current): return True
                current += 1
            return False

        return dfs(0, 0)

    # dp
    def checkValidString(self, s: str) -> bool:
        if not s: return True
        n = len(s)
        dp = [[False] * (n + 1) for _ in range(n + 1)]
        dp[0][0] = True
        for i in range(1, n + 1):
            for j in range(n):
                if s[i - 1] == '(':
                    dp[i][j] = dp[i - 1][j - 1]
                elif s[i - 1] == ')':
                    dp[i][j] = dp[i - 1][j + 1]
                else:
                    dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - 1], dp[i - 1][j + 1])
        return dp[n][0]

    # greedy
    def checkValidString(self, s: str) -> bool:
        lo = hi = 0
        for c in s:
            lo += 1 if c == '(' else -1
            hi += 1 if c != ')' else -1
            if hi < 0: break
            lo = max(0, lo)
        return lo == 0


'''
"()"
"(((((((((*****)))***((())(((**)(((((((((*****)))***((())(((**)(((((((((*****)))***((())(((**)"
"(*)"
"(*))"
'''
if __name__ == '__main__':
    obj = _678_Solution()
    assert obj.checkValidString("()")
    assert obj.checkValidString("(*)")
    assert obj.checkValidString("(*))")
