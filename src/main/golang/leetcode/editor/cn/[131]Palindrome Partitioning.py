from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        n = len(s)
        dp = [[True] * n for _ in range(n)]
        for i in range(n - 1, -1, -1):
            for j in range(i + 1, n):
                dp[i][j] = s[i] == s[j] and dp[i + 1][j - 1]

        ans = []
        path = []

        def dfs(i):
            if i == n:
                ans.append(path[:])
                return
            for j in range(i, n):
                if dp[i][j]:
                    path.append(s[i:j + 1])
                    dfs(j + 1)
                    path.pop()

        dfs(0)
        return ans
# leetcode submit region end(Prohibit modification and deletion)
