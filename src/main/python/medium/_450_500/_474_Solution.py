# 474. Ones and Zeroes
from typing import List


class _474_Solution:
    # use dfs
    def findMaxForm(self, strs: List[str], m: int, n: int) -> int:
        maximal, size = -1, len(strs)

        def backtrack(index: int, acc: int, r0: int, r1: int) -> None:
            nonlocal maximal
            if index >= size:
                if r0 == 0 and r1 == 0:
                    maximal = max(acc, maximal)
                return
            curr = strs[index]
            if curr.count('0') <= r0 and curr.count('1') <= r1:
                backtrack(index + 1, acc + 1, r0 - curr.count('0'), r1 - curr.count('1'))
            backtrack(index + 1, acc, r0, r1)

        backtrack(0, 0, m, n)
        return maximal

    # use dp
    def findMaxForm(self, strs: List[str], m: int, n: int) -> int:
        dp = [[0] * (n + 1) for _ in range(m + 1)]
        for s in strs:
            zeros, ones = s.count('0'), s.count('1')
            for i in reversed(range(zeros, m + 1)):
                for j in reversed(range(ones, n + 1)):
                    dp[i][j] = max(dp[i][j], dp[i - s.count('0')][j - s.count('1')] + 1)
        return dp[m][n]

'''
["10","0001","111001","1","0"]
5
3
["1"]
1
2
["0"]
0
0
'''
if __name__ == '__main__':
    obj = _474_Solution()
    assert obj.findMaxForm(["10", "0", "1"], 1, 1) == 2
    assert obj.findMaxForm(["10", "0001", "111001", "1", "0"], 5, 3) == 4
