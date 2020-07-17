# 646. Maximum Length of Pair Chain
from typing import List


class _646_Solution:
    # dp
    def findLongestChain(self, pairs: List[List[int]]) -> int:
        if not pairs or not pairs[0]: return 0
        pairs.sort(key=lambda x: x[0])
        dp = [1] * len(pairs)
        for i in range(1, len(pairs)):
            s = pairs[i][0]
            for j in range(0, i):
                e = pairs[j][1]
                if s > e:
                    dp[i] = max(dp[i], dp[j] + 1)
        return dp[-1]

    # greedy
    def findLongestChain(self, pairs: List[List[int]]) -> int:
        if not pairs or not pairs[0]: return 0
        pairs.sort(key=lambda x: x[1])
        curr, ans = -0x7ffffff, 0
        for pair in pairs:
            if curr < pair[0]:
                ans += 1
                curr = pair[1]
        return ans
