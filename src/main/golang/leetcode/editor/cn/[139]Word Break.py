from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        word_dict = {word for word in wordDict}
        n = len(s)
        dp = [False] * (n + 1)
        dp[0] = True
        for i in range(1, n + 1):
            for j in range(i):
                dp[i] |= dp[j] and s[j:i] in word_dict
        return dp[-1]
# leetcode submit region end(Prohibit modification and deletion)
