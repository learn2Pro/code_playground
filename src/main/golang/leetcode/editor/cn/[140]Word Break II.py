from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> List[str]:
        word_dict = {word for word in wordDict}
        n = len(s)
        dp = [False] * (n + 1)
        dp[0] = True
        for i in range(1, n + 1):
            for j in range(i):
                dp[i] |= dp[j] and s[j:i] in word_dict

        ans = []

        def dfs(index, path):
            if index == 0:
                ans.append(' '.join(path[::-1]))
                return
            for i in range(index):
                if dp[i] and s[i:index] in word_dict:
                    path.append(s[i:index])
                    dfs(i, path)
                    path.pop()

        dfs(n, [])
        return ans
# leetcode submit region end(Prohibit modification and deletion)
